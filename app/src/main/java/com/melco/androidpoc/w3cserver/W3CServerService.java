package com.melco.androidpoc.w3cserver;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;

/**
 * Created by danieln on 2017-08-22.
 */
public class W3CServerService extends IntentService {

    private static final String TAG = "W3CServerService";
    private static boolean serviceRunning = false;

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public W3CServerService() {
        super("W3CServerService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!serviceRunning) {
            serviceRunning = true;
            Toast.makeText(this, "W3CServer background service started", Toast.LENGTH_LONG).show();
            Log.d(TAG, "onStartCommand");
            return super.onStartCommand(intent, flags, startId);
        }
        else
        {
            Toast.makeText(this, "W3CServer background already running", Toast.LENGTH_LONG).show();
            Log.d(TAG, "onStartCommand: already started");
            return START_REDELIVER_INTENT;
        }
    }

    @Override
    public void onDestroy() {
        serviceRunning = false;
        Toast.makeText(this, "W3CServer background service stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        int i = 0;
        while (true) {
            i++;
            try {
                Thread.sleep(1000);
                Log.d(TAG, "handle intent loop: " + i);

            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
        }
    }
}

/*
public class W3CServerService extends Service {

    private static final String TAG = "MyService";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        Toast.makeText(this, "W3CServer background service stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onStart(Intent intent, int startid)
    {
        Intent intents = new Intent(getBaseContext(),W3CServerActivity.class);
        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intents);
        Toast.makeText(this, "W3CServer background service started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
    }
}
*/