package com.melco.androidpoc.w3cserver;

/**
 * Created by Pether on 2017-09-01.
 */

public enum W3CError {
    ERROR_NO_ERROR (0, "No Error occurred, oops?"),
    ERROR_GENERAL (1, "General Error");


    private final int _errorCode;
    private final String _message;

    W3CError(int errorCode, String message) {
        this._errorCode = errorCode;
        this._message = message;
    }

    public int get_errorCode() { return _errorCode; }

    public String get_message() { return _message; }
}
