package com.spring.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        ((StompEndpointRegistry) registry).addEndpoint("ws").withSockJS();
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        ((MessageBrokerRegistry) registry).setApplicationDestinationPrefixes("/app");
        ((MessageBrokerRegistry) registry).enableSimpleBroker("/topic");
    }
    
}
