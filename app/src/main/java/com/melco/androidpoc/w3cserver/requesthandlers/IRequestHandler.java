package com.melco.androidpoc.w3cserver.requesthandlers;

import com.melco.androidpoc.w3cserver.W3CErrorException;

public interface IRequestHandler {
	void HandleRequest() throws W3CErrorException;
}
