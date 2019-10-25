package com.honeygoose.wifiadmin.config

import com.honeygoose.wifiadmin.model.UserRole
import com.honeygoose.wifiadmin.security.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.OrRequestMatcher

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
        var provider: AuthenticationProvider
) : WebSecurityConfigurerAdapter() {
    val requestMatcher = OrRequestMatcher(AntPathRequestMatcher("/api/v1/report/**"),
            AntPathRequestMatcher("/api/v1/admin/**"))

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.authenticationProvider(provider)
    }

    override fun configure(web: WebSecurity?) {
        web?.ignoring()
                ?.antMatchers("/api/v1/login/**")
                ?.antMatchers("/swagger-ui.html")
                ?.antMatchers("/webjars/springfox-swagger-ui/**")
                ?.antMatchers("/swagger-resources/**")
                ?.antMatchers("/v2/api-docs")
                ?.antMatchers("/speedtest/**")
    }

    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .exceptionHandling()
                    .and()
                    .authenticationProvider(provider)
                    .addFilterBefore(authenticationFilter(), AnonymousAuthenticationFilter::class.java)
                    .authorizeRequests()
                    .antMatchers("/api/v1/admin/**").hasAuthority(UserRole.ADMIN.code)
                    .anyRequest().authenticated()
                    .and()
                    .csrf().disable()
                    .formLogin().disable()
                    .httpBasic().disable()
                    .logout().disable()
        }
    }

    @Bean
    fun authenticationFilter(): AuthenticationFilter {
        val filter = AuthenticationFilter(requestMatcher)
        filter.setAuthenticationManager(authenticationManager())
        //filter.setAuthenticationSuccessHandler(successHandler());
        return filter
    }

    @Bean
    fun forbiddenEntryPoint(): AuthenticationEntryPoint {
        return HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
    }
}
