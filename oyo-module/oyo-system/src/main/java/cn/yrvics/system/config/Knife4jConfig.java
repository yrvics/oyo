package cn.yrvics.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDateTime;


@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("oyo-system").description("oyo系统相关功能")
                .version("1.0").contact(new Contact("yrvics", "", "yrvics@outlook.com"))
                .build();
    }


    @Bean(value = "systemApi")
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime.class,String.class)
                .apiInfo(apiInfo())
                .groupName("oyo：系统相关")
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }
}
