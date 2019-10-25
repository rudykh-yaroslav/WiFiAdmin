package com.honeygoose.wifiadmin.config

import com.google.common.collect.Lists
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.paths.RelativePathProvider
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.servlet.ServletContext


@Configuration
@EnableSwagger2
class SwaggerConfig {

    val AUTHORIZATION_HEADER = "AUTHORIZATION"
    val DEFAULT_INCLUDE_PATTERN = "/api/v1/.*"

    @Value("\${app.root-package}")
    private lateinit var rootPackage: String

    @Autowired
    lateinit var swaggerPathProvider: SwaggerPathProvider

    @Bean
    fun api(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(rootPackage))
                    .paths(PathSelectors.any())
                    .build()
                    .pathProvider(swaggerPathProvider)
                    .securityContexts(Lists.newArrayList(securityContext()))
                    .securitySchemes(Lists.newArrayList(apiKey()))

    private fun apiKey(): ApiKey =
            ApiKey("Bearer", AUTHORIZATION_HEADER, "header")

    private fun securityContext(): SecurityContext =
            SecurityContext.builder()
                    .securityReferences(defaultAuth())
                    .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                    .build()

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScopes = arrayOf(AuthorizationScope("global", "accessEverything"))
        return Lists.newArrayList(SecurityReference("Bearer", authorizationScopes))
    }

}

@Component
class SwaggerPathProvider(
        servletContext: ServletContext
) : RelativePathProvider(servletContext) {

    @Value("\${app.base-path:/}")
    private lateinit var basePath: String

    override fun getApplicationBasePath() = basePath
}