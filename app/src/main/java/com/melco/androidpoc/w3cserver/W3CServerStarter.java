package com.melco.androidpoc.w3cserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by danieln on 2017-08-22.
 */

public class W3CServerStarter extends BroadcastReceiver {

    private static final String TAG = "W3CServerStarter";

    public void onReceive(Context context, Intent arg1)
    {
        Intent intent = new Intent(context,W3CServerService.class);
        context.startService(intent);
        Log.d(TAG, "started");
    }
}