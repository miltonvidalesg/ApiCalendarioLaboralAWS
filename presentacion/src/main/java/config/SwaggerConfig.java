package calendariolaboral.api.presentacion.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI configurarOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("API Cambio de Monedas")
                                                .description("API para gestionar cambio de monedas")
                                                .version("1.0.0"))
                                .addSecurityItem(new SecurityRequirement().addList("Bearer"))
                                .components(new io.swagger.v3.oas.models.Components()
                                                .addSecuritySchemes("Bearer", new SecurityScheme()
                                                                .type(SecurityScheme.Type.HTTP)
                                                                .scheme("bearer")
                                                                .bearerFormat("JWT")
                                                                .description("Ingresa el token JWT")));

        }
}