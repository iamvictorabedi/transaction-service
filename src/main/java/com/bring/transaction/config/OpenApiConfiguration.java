package com.bring.transaction.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class OpenApiConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfo("Backbase Transaction Service",
                    "Transaction Service that retrives transaction data from OpenApi to Backbase",
                    "", "urn:tos", DEFAULT_CONTACT,
                    "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                    emptyList()))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.bring.transaction.api"))
            .paths(PathSelectors.any())
            .build();
  }


  /**
   * Exclude interfaces marked with 'FeignClient', so that they don't show in SwaggerUI
   */
  @Bean
  public WebMvcRegistrations feignWebRegistrations() {
    return new WebMvcRegistrations() {
      @Override
      @SuppressWarnings({"java:S110"})
      public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping() {
          @Override
          protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && (isNull(findAnnotation(beanType, FeignClient.class)));
          }
        };
      }
    };
  }
}
