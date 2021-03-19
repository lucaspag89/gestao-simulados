package com.lucas.exams.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lucas.exams.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageGet())
                .globalResponseMessage(RequestMethod.POST, responseMessagePost())
                .globalResponseMessage(RequestMethod.PUT, responseMessagePut())
                .globalResponseMessage(RequestMethod.DELETE, responseMessageDelete())
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API Documentation for Exams App")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    private List<ResponseMessage> responseMessageGet() {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(404)
                        .message("Not Found")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .build());
            }
        };

    }

    private List<ResponseMessage> responseMessagePost() {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(201)
                        .message("Created")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(404)
                        .message("Not Found")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .build());
            }
        };
    }

    private List<ResponseMessage> responseMessagePut() {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(404)
                        .message("Not Found")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .build());
            }
        };
    }

    private List<ResponseMessage> responseMessageDelete() {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(204)
                        .message("OK")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(404)
                        .message("Not Found")
                        .build());
                add(new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .build());
            }
        };
    }
}
