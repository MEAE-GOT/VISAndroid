package com.melco.androidpoc.w3cserver;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by Pether on 2017-08-25.
 */

public class W3CErrorException extends Exception {

    private W3CError _error = W3CError.ERROR_NO_ERROR;

    public W3CErrorException(W3CError error) {
        this._error = error;
    }

    public int getErrorCode() {
        return this._error.get_errorCode();
    }

    public String getErrorMessage() {
        return this._error.get_message();
    }

}
