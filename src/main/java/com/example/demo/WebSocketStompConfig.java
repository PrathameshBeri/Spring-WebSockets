package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {
	
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/marcopolo").withSockJS();
	}

	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableStompBrokerRelay("/topic", "/queue")
				.setRelayHost("localhost")
				.setRelayPort(61613)
				.setClientLogin("guest")
				.setClientPasscode("guest");
		//registry.setApplicationDestinationPrefixes("/app", "/foo");
	}
	
	
	
	
}
