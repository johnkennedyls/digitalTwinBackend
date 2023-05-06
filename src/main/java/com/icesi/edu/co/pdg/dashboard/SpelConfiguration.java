package com.icesi.edu.co.pdg.dashboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
public class SpelConfiguration {
	
	@Bean
    public SpelExpressionParser spelExpressionParser() {
        return new SpelExpressionParser();
    }

}
