package com.icesi.edu.co.pdg.dashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.edu.icesi.dev.saamfi.saamfisecurity.filters.SaamfiAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${saamfi.api.url}")
	private String saamfiUrl;
	@Value("${saamfi.api.systems.dashboard.id}")
	private String systemId;
	@Value("${saamfi.api.institutions.icesi.id}")
    private String institutionId;
	
	@Bean
    SaamfiAuthenticationFilter getSaamfiAuthenticationFilter() {
        return new SaamfiAuthenticationFilter(saamfiUrl,Long.parseLong(systemId),Long.parseLong(institutionId));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/public/**")
                .permitAll().anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(getSaamfiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}