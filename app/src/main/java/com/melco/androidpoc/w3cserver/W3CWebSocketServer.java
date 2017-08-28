package com.melco.androidpoc.w3cserver;

import java.net.InetSocketAddress;

import android.util.Log;

import com.melco.androidpoc.w3cserver.requesthandlers.RequestHandler;
import com.melco.androidpoc.w3cserver.requests.Request;
import com.melco.androidpoc.w3cserver.signalinterface.AndroidSignalInterface;
import com.melco.androidpoc.w3cserver.signalinterface.SignalInterface;

import org.java_websocket.*;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.*;

public class W3CWebSocketServer extends WebSocketServer {

	public W3CWebSocketServer(InetSocketAddress address ) {
		super( address );
		}
	
	@Override
	public void onClose(WebSocket socket, int arg1, String arg2, boolean arg3) {
		// TODO Auto-generated method stub
		System.out.println("Connection closed.");
		Log.d(Constants.LOG_TAG, "Connection Closed.");

	}

	@Override
	public void onError(WebSocket socket, Exception arg1) {
		// TODO Auto-generated method stub
		System.out.println("W3CWebSocketServer Error : " + arg1.getMessage());
		//arg1.printStackTrace();
		Log.e(Constants.LOG_TAG, "W3CWebSocketServer Error : " + arg1.getMessage());
	}

	@Override
	public void onMessage(WebSocket socket, String message) {
		W3CWebSocket clientsocket = (W3CWebSocket)socket;

        Log.d(Constants.LOG_TAG, "Message Received on W3CWebSocketServer");
        if(!RequestHandler.ValidateRequest(message)){
            clientsocket.send("Request failed validation");
            return;
        }
        clientsocket.send("Request passed validation");

        // TODO make this return an error code instead of object, return error to client
        Request request = new Request(message);

        // TODO make this return an error code instead of object, return error to client
        SignalInterface signalinterface = new AndroidSignalInterface();

        // TODO make this return an error code instead of object, return error to client
        RequestHandler handler = RequestHandler.ProcessRequest(clientsocket, request, signalinterface);

        handler.HandleRequest();

	}

	@Override
	public void onOpen(WebSocket socket, ClientHandshake handshake) {
		Log.d(Constants.LOG_TAG, "Connection Opened on W3CWebSocketServer");

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.d(Constants.LOG_TAG, "W3CWebSocketServer started.");
	}

}
