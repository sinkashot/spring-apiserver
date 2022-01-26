package com.sinkashot.api;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {
	private static final ArrayList<Session> sessionList = new ArrayList<>();
	
	@OnOpen
	public void handleOpen(Session session) {
		if (session != null) {
			String sessionId = session.getId();
			
			System.out.println("connected ["+sessionId+"]");
			sessionList.add(session);
		}
	}
	
	@OnClose
	public void handleClose(Session session) {
		if (session != null) {
			String sessionId = session.getId();
			System.out.println("disconnected ["+sessionId+"]");
		}
	}
	
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	@OnMessage
	public String handleMessage(String message, Session session) {
		if (session != null) {
			String sessionId = session.getId();
			System.out.println("["+sessionId+"] message : "+message);
		}
		
		return null;
	}
}
