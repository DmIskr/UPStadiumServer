package com.example.komitetserver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Система для подбора стадиона",
                version = "1.0.0",
                contact = @Contact(
                        name = "Дмитрий Искренок",
                        email = "diskrenok05bk.ru"
                )
        )
)
public class OpenApiConfig {

}