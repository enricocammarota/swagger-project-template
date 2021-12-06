package it.testproj.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Metodo richiamato dal framework per la configurazione di Swagger. In tale metodo è creato un oggetto che rappresenta
     * tutti i dati di configurazione che devono essere passati al framework Springfox per la generazione della
     * documentazione in maniera automatica per le API Rest partendo dal codice sorgente.
     *
     * @return un oggetto Docket con variabili valorizzate con i dati da passare a Swagger per la sua configurazione
     */
    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("it.testproj"))
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    /** Generates all the API Information to be used by Swagger.
     *
     * @return {@link ApiInfo} containing all the API information. It includes Contact and service purpose information.
     *
     */
    private ApiInfo apiInfo() {

        List<VendorExtension> vendorExtensions = new ArrayList<>();

        Contact contact = new Contact(
                "Enrico Cammarota",
                "http://www.enricocammarota.com/",
                "foo@bar.com"
        );

        return new ApiInfo(
                "Swagger Project Template",
                "Servizio di test per la configurazione swagger",
                "1.0",
                "Terms of service",
                contact,
                "License of API",
                "API license URL",
                vendorExtensions);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/v2/api-docs",
                "/v2/api-docs");
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/api/swagger-resources/configuration/security",
                "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/api/swagger-resources",
                "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/api/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
