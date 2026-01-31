package io.github.gabriellrocha.myapp.config;

import io.github.gabriellrocha.myapp.domain.Coach;
import io.github.gabriellrocha.myapp.domain.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    /*
     * O principal cenário de uso do @Bean é quando precisamos registrar um Bean cuja
     * classe não pode ser anotada com @Component, como em classes de biblioteca
     * de terceiros
     *
     * */
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
