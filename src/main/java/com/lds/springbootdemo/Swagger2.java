package com.lds.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * api接口管理    访问：ip:port/web name/swagger-ui.html
 * @author admin
 *
 */
@EnableSwagger2
@Configuration
public class Swagger2 {
	
	@Bean
    public Docket createRestApi() {
//		ParameterBuilder tokenPar = new ParameterBuilder();
//    	List<Parameter> pars = new ArrayList<Parameter>();
//    	tokenPar.name("USER-TOKEN").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//    	pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lds.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springbootdemo")
                .description(" springbootdemo web API")
                .termsOfServiceUrl("springbootdemo")
                .version("1.0")
                .build();
    }
	

}
