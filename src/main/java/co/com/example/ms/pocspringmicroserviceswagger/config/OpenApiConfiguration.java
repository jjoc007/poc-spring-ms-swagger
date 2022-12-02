package co.com.example.ms.pocspringmicroserviceswagger.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import javax.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "${open_api.tittle}",
                description = "${open_api.description}",
                contact = @Contact(
                        name = "${open_api.contact.name}",
                        email = "${open_api.contact.email}"
                )
        ),
        servers = {
                @Server(url = "${open_api.servers.local.url}",
                        description = "${open_api.servers.local.description}"),
                @Server(url = "${open_api.servers.production.url}",
                        description = "${open_api.servers.production.description}") }
)
public class OpenApiConfiguration {

    @Bean
    public ModelResolver modelResolver(@NotNull ObjectMapper mapper) {
        return new ModelResolver(mapper);
    }

}
