package com.melco.androidpoc.w3cserver;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by Pether on 2017-08-25.
 */

public class Error {
    public static final int ERROR_NO_ERROR = 0;
    public static final int ERROR_GENERAL_ERROR = 1;
    public static final int ERROR_404 = 404;
    public static final int ERROR_42 = 42;
    public static final int ERROR_1337 = 1337;

    public static final Map<Integer, String> ErrorMessages= ImmutableMap.<Integer, String>builder()
            .put(ERROR_NO_ERROR,            "")
            .put(ERROR_GENERAL_ERROR,       "")
            .put(ERROR_404,                 "")
            .put(ERROR_1337,                "The cake is a lie")
            .put(ERROR_42,                  "Something something dark side")
            .build();
}
