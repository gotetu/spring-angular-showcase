package com.github.gotetu.springangularshowcase.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(
                CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
            .exceptionHandling()
            .authenticationEntryPoint(((request, response, authException) -> {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }))
        .and().oauth2Login()
            .defaultSuccessUrl("/",true)
        .and().authorizeRequests()
            .mvcMatchers("/api/v1/ccount").authenticated()
            .mvcMatchers(HttpMethod.POST, "/api/**/*").authenticated()
            .mvcMatchers(HttpMethod.PUT, "/api/**/*").authenticated()
            .mvcMatchers(HttpMethod.DELETE, "/api/**/*").authenticated()
        .anyRequest().permitAll();
    }
}
