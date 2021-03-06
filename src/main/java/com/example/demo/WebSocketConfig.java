package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@EnableWebSocket
@Controller
public class WebSocketConfig implements WebSocketConfigurer {
	

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(marcoHandler(), "/marco");
		
	}

	
	
	@Bean
	public MarcoHandler marcoHandler() {
		return new MarcoHandler();
	}
}
