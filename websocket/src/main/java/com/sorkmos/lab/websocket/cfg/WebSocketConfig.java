package com.sorkmos.lab.websocket.cfg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

import com.sorkmos.lab.websocket.handler.MessageHandler;

@Configuration
@EnableWebSocket
@EnableAutoConfiguration
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(messageHandler(), "/logSocket").withSockJS();
	}
	
	@Bean
	public WebSocketHandler messageHandler() {
		return new PerConnectionWebSocketHandler(MessageHandler.class);
	}
}

