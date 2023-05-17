package com.icesi.edu.co.pdg.dashboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
@EnableAspectJAutoProxy
public class SpelConfiguration {
	
	@Bean
    public SpelExpressionParser spelExpressionParser() {
        return new SpelExpressionParser();
    }

}
