package com.rosca.customer.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {


    @Bean
    public OpenAPI SpringDocSettings(){

        return new OpenAPI()
                .info(new Info().title("Rosca - Customer")
                        .description("Swagger documentation for customer entity in Rosca")
                        .version("0.0.1")
                        .contact(new Contact().email("guillenmartins@gmail.com")
                                .name("Renato Martins")
                                .url("https://github.com/guimar86/rosca")))
                .externalDocs(new ExternalDocumentation()
                        .description("Wiki about Rosca")
                        .url("https://github.com/guimar86/rosca/wiki"));
    }
}
