package com.halo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun document(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
    }

//    private fun paths(): Predicate<String> {
//        // ドキュメント生成の対象とするAPIのURLを指定
//        // この場合、「/user」で始まるAPIがドキュメント生成対象となる
//        return Predicates.or(Predicates.containsPattern("/user"))
//    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Example API")
                .description("sample application")
                .version("1.0")
                .build()
    }
}