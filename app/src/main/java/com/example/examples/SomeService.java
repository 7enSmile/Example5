package com.example.examples;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


import static java.lang.Thread.sleep;

import androidx.annotation.Nullable;

import java.util.concurrent.TimeUnit;

public class SomeService extends Service {
    private static final String LOG_TAG ="hs" ;
    Context context;

    public void onCreate() {



        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        context = getApplicationContext();

        Toast.makeText(this, "Служба запущена",Toast.LENGTH_SHORT).show();

            startWork();



        return super.onStartCommand(intent, flags, startId);

    }


    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        Toast.makeText(this, "Служба остановлена",Toast.LENGTH_SHORT).show();
        super.onDestroy();

    }

    private void startWork()  {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int timer=0;timer<100;timer++){
                    Log.d("timer", String.valueOf(timer));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                }
                stopSelf();
            }
        }).start();


    }




}
