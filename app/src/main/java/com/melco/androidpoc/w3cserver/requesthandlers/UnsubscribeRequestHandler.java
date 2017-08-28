package com.melco.androidpoc.w3cserver.requesthandlers;

import android.util.Log;

import com.melco.androidpoc.w3cserver.Constants;
import com.melco.androidpoc.w3cserver.W3CWebSocket;
import com.melco.androidpoc.w3cserver.requests.Request;
import com.melco.androidpoc.w3cserver.signalinterface.SignalInterface;

/**
 * Created by Pether on 2017-08-25.
 */

public class UnsubscribeRequestHandler extends RequestHandler {

    public UnsubscribeRequestHandler(W3CWebSocket clientsocket, Request request, SignalInterface signalinterface) {
        super(clientsocket, request, signalinterface);

    }

    @Override
    public void HandleRequest() {
        Log.d(Constants.LOG_TAG, "W3CWebSocketServer, Received : UnsubscribeRequest");
        this._clientsocket.send("Received : UnsubscribeRequest");

    }
}
