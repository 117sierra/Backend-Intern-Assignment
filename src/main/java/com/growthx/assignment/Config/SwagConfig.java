package com.growthx.assignment.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwagConfig {
    @Value("${swagger.url}")
    private String devurl;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl(devurl);
        server.setDescription("Server url ");

        Contact contact = new Contact();
        contact.setUrl("https://github.com/117sierra/Backend-Intern-Assignment");
        contact.setName("Gurdeep");
        contact.setEmail("gurdeep@gmail.com");

        License license = new License().name("N/A").url("https://github.com/117sierra/Backend-Intern-Assignment");

        Info info = new Info().title("GrowthX Intern Project").version("1.0").contact(contact).description("N/A").
                license(license).termsOfService("N/A");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
