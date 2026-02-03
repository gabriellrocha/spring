package io.github.gabriellrocha.myapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails gabriel = User.builder()
                .username("gabriel")
                .password("{noop}gabriel123")
                .roles("ADMIN")
                .build();

        UserDetails maria = User.builder()
                .username("maria")
                .password("{noop}maria123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(gabriel, maria);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        /* No Spring, as permissões são verificadas de forma literal. Ou seja, ter a Role ADMIN
        *  não dá automaticamente ao usuários privilégios de USER. Para resolver:
        *  1. Add multiplas Roles na config: .requestMatchers(/api/v1/users).hasRole("USER", "ADMIN")
        *  2. Config Hierarquia de Roles (recomendado) - impl logo abaixo..
        * */

        httpSecurity.authorizeHttpRequests(configurer ->

                configurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/users").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/v1/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasRole("ADMIN")
                );

                // Habilita a autenticação HTTP Basic
                // Instrui o Spring a procurar e validar(em todas as request) o header "Authorization: Basic <base64>"
                httpSecurity.httpBasic(Customizer.withDefaults());

                // Desabilita a proteção CSRF (ativa por padrão no Spring)
                // Seguro para APIs que não utilizam Cookies de sessão (Stateless/Tokens)
                httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return  httpSecurity.build();
    }

    @Bean
    static RoleHierarchy roleHierarchy() {
        // Hierarquia de Roles - ADMIN herda as permissões de USER
        return RoleHierarchyImpl.fromHierarchy("ROLE_ADMIN > ROLE_USER");
    }
}
