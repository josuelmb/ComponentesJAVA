package pe.edu.idat.proyecto.gestion.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Documentacion del proyecto de las operaciones que trabajamos
@Configuration

public class SwaggerConfig {
    @Bean
    public OpenAPI soporteApiConfig(){

        return new OpenAPI()
        .info(new Info()
                .title("Soporte Tecnico")
                .description("Soporte Tecnico a clientes")
                .version("1.0")
                .contact(new Contact()
                        .name("Grupo 1")
                        .email("IV76705525@idat.pe")
                        .url("https://github.com/josuelmb/ComponentesJAVA")
                )
                .license(new License()
                        .name("Proyecto Soporte Tecnico a clientes")
                        .url("https://github.com/josuelmb/ComponentesJAVA")
                ));

    }
}
