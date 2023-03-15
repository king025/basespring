package ph.bpi.com.springboot3swagger2.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

//    @Value("${app.api.version}")
//    private String version;

    @Value("${app.api.title}")
    private String title;

    @Value("${app.api.description}")
    private String description;

    @Value("${app.api.externalDocDescription}")
    private String externalDocDescription;

    @Value("${app.api.externalUrl}")
    private String externalUrl;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(title)
                        .description(description)
                        .version("version")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org/v2")))
                .externalDocs(new ExternalDocumentation()
                        .description(externalDocDescription)
                        .url(externalUrl));
    }
}
