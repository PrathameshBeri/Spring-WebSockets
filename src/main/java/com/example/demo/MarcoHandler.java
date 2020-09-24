package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MarcoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(MarcoHandler.class);

	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("Received message: + " + message.getPayload());
		System.out.println("Received message: + " + message.getPayload());
		Thread.sleep(2000);
		session.sendMessage(new TextMessage("Polo"));

	}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Connection established");
		System.out.println("Connection established");
	}

	public void afterConnectionClosed(WebSocketSession sesssion, CloseStatus status) {
		logger.info("Connection closed. Status: " + status.getReason());
		System.out.println("Connection closed. Status: " + status.getReason());

	}

}
