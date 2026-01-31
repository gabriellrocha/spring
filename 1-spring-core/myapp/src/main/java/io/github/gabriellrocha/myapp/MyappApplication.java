package io.github.gabriellrocha.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Component Scan personalizado - Substitui o Scan padrão
//@SpringBootApplication(
//        scanBasePackages = {
//                "io.github.gabriellrocha.myapp",
//                "io.github.gabriellrocha.util"
//        }
//)

@SpringBootApplication
public class MyappApplication {

    /*
     * @SpringBootApplication anotação composta:
     *  @EnableAutoConfiguration - Ativa a autoconfiguração com base no classpath e propriedades
     *  @ComponentScan - Escaneia o pacote da classe main e subpacotes
     *  @Configuration - Permite declarar Beans com @Bean e importar configs
     * */

    public static void main(String[] args) {
        SpringApplication.run(MyappApplication.class, args);

        /*
         * SpringApplication.run():
         *  Cria o ApplicationContext(Container do Spring)
         *  Carrega e registra todos os beans
         *   Component Scan
         *   @Bean
         *   auto-configuration
         *  Resolve dependências e inicializa os beans
         *  Inicia o servidor web embutido(Tomcat, por padrão) - Somente se o projeto for web(spring-boot-starter-web)
         * */
    }
}
