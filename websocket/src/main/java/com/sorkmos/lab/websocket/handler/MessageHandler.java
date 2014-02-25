package com.sorkmos.lab.websocket.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MessageHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		System.out.println(("Opened new session in instance " + session.getAcceptedProtocol()));
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
		
		while(true) {
			session.sendMessage(new TextMessage(df.format(new Date())));
			Thread.sleep(1000);
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println("connection closed");
	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		session.close(CloseStatus.SERVER_ERROR);
	}
}