package com.melco.androidpoc.w3cserver;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

import org.java_websocket.*;
import org.java_websocket.drafts.Draft;
import org.java_websocket.server.WebSocketServer.WebSocketServerFactory;

public class W3CWebSocketServerFactory implements WebSocketServerFactory {
	
	@Override
	public W3CWebSocket createWebSocket( WebSocketAdapter a, Draft d) {
		return new W3CWebSocket( a, d );
	}
	
	@Override
	public W3CWebSocket createWebSocket( WebSocketAdapter a, List<Draft> d) {
		return new W3CWebSocket( a, d );
	}

	
	@Override
	public void close() {
		
	}

	@Override
	public ByteChannel wrapChannel(SocketChannel arg0, SelectionKey arg1) throws IOException {
		return arg0;
	}
}
