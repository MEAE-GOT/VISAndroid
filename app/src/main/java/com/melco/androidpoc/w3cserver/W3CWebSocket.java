package com.melco.androidpoc.w3cserver;

import java.util.List;

import org.java_websocket.*;
import org.java_websocket.drafts.Draft;

public class W3CWebSocket extends WebSocketImpl {

	public W3CWebSocket(WebSocketListener listener, Draft draft) {
		super(listener, draft);
		// TODO Auto-generated constructor stub
		
	}
	
	public W3CWebSocket(WebSocketListener listener, List<Draft> draft) {
		super(listener, draft);
		// TODO Auto-generated constructor stub
		
	}
}
