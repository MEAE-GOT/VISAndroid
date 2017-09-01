package com.melco.androidpoc.w3cserver.requests;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.melco.androidpoc.w3cserver.W3CError;
import com.melco.androidpoc.w3cserver.W3CErrorException;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Pether on 2017-08-25.
 */

public class Request {
    public JsonNode _jsonNode;

    public Request(String message) throws W3CErrorException {
        try {
            _jsonNode = JsonLoader.fromString(message);
        } catch (IOException e) {
            //e.printStackTrace();
            throw new W3CErrorException(W3CError.ERROR_GENERAL);
        }
    }

    public String GetAction() {
        return _jsonNode.get("action").asText();
    }
}
