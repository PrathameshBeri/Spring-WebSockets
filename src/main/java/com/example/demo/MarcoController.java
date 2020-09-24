package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class MarcoController {

	
	private static final Logger logger = LoggerFactory.getLogger(MarcoController.class);
	
	private SimpMessageSendingOperations messaging;
	
	@MessageMapping("/marco")
	public void handleShout(Shout incoming) {
		System.out.println("incoming shout " + incoming.getMessage());
		broadcastMessage();
	}
	
	public void broadcastMessage() {
		
		messaging.convertAndSend("/topic/wsfeed", "HEllo bro");
	}
	
}
