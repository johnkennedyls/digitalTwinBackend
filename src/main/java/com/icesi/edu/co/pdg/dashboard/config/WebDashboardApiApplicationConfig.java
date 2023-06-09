package com.icesi.edu.co.pdg.dashboard.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
@EnableAspectJAutoProxy
public class WebDashboardApiApplicationConfig implements WebSocketMessageBrokerConfigurer {
	
	@Value("${mqtt.server.uri}")
    private String mqttServerUri;
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/public/websocket").setAllowedOriginPatterns("*").withSockJS();
    }

	@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Bean
    SpelExpressionParser spelExpressionParser() {
        return new SpelExpressionParser();
    }
    
    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient client = new MqttClient("tcp://"+mqttServerUri, MqttClient.generateClientId(), new MemoryPersistence());
        return client;
    }
}
