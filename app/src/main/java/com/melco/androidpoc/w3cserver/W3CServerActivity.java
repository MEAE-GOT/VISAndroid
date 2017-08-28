package com.melco.androidpoc.w3cserver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;

/**
 * Created by danieln on 2017-08-22.
 */

public class W3CServerActivity extends Activity {

    private static final String TAG = "W3CServerActivity";

    public void onCreate(Bundle savedInstanceState)
    {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        Toast.makeText(getBaseContext(), "W3CServer", Toast.LENGTH_LONG).show();

        //If background service not running, start it
        Intent intent = new Intent(this, W3CServerStarter.class);
        sendBroadcast(intent);
    }
}