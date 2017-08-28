package com.melco.androidpoc.w3cserver.requests;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pether on 2017-08-25.
 */

public class Request {
    public JSONObject _jsonObject;

    public Request(String message){
        try {
            _jsonObject = new JSONObject(message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String GetAction() throws JSONException {
        return _jsonObject.getString("action");
    }
}
