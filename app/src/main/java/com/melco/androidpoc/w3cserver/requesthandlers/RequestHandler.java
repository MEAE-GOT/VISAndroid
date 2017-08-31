package com.melco.androidpoc.w3cserver.requesthandlers;


import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.melco.androidpoc.w3cserver.Constants;
import com.melco.androidpoc.w3cserver.W3CWebSocket;
import com.melco.androidpoc.w3cserver.requests.Request;
import com.melco.androidpoc.w3cserver.signalinterface.SignalInterface;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class RequestHandler implements IRequestHandler {
	protected Request _request;
	protected W3CWebSocket _clientsocket;
	protected SignalInterface _signalinterface;
	
	protected RequestHandler(W3CWebSocket clientsocket, Request request, SignalInterface signalinterface) {
		this._clientsocket = clientsocket;
		this._request = request;
		this._signalinterface = signalinterface;
	}

    private static JsonSchema schema;
	public static boolean SetJsonSchema(InputStream is){
        try {
            JsonNode fstabSchema = JsonLoader.fromReader(new InputStreamReader(is));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            schema = factory.getJsonSchema(fstabSchema);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ProcessingException e) {
            //e.printStackTrace();
            return false;
        }
    }

	public static boolean ValidateRequest(String json) {
		try {
			JsonNode node = JsonLoader.fromString(json);
			ProcessingReport report = schema.validate(node);

			return report.isSuccess();

		} catch (IOException e) {
			e.printStackTrace();
            return false;
		}
		catch (ProcessingException e) {
			//e.printStackTrace();
            return false;
		}
	}

	public static RequestHandler ProcessRequest(W3CWebSocket clientsocket, Request request, SignalInterface signalinterface) {

		try {
			switch(request.GetAction()){
				case Constants.REQUEST_GET:
					return new GetRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_SET:
					return new SetRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_AUTHORIZE:
					return new AuthorizeRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_GETMETADATA:
					return new GetMetadataRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_SUBSCRIBE:
					return new SubscribeRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_UNSUBSCRIBE:
					return new UnsubscribeRequestHandler(clientsocket, request, signalinterface);
				case Constants.REQUEST_UNSUBSCRIBEALL:
					return new UnsubscribeAllRequestHandler(clientsocket, request, signalinterface);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
