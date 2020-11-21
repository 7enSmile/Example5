package com.example.examples;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;


import static java.lang.Thread.sleep;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.concurrent.TimeUnit;

public class SomeService extends Service {

    Context context;
    Thread thread;
    boolean running=true;
    String text;
    Intent mIntent;
    Bundle mBundle;

    public void onCreate() {





        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        context = getApplicationContext();


        Toast.makeText(this, "Служба запущена",Toast.LENGTH_SHORT).show();
        mIntent = new Intent(this, ActivityService.class);
        mBundle = new Bundle();



            startWork();



        return super.onStartCommand(intent, flags, startId);

    }


    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        Toast.makeText(this, "Служба остановлена",Toast.LENGTH_SHORT).show();


        running=false;
        super.onDestroy();

    }

    private void startWork()  {
        final Handler handler=new Handler();
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int timer=1;timer<512;timer=timer*2){
                    if(!running){
                        break;
                    }
                    Intent in = new Intent("progress");
                    in.putExtra("Progress", timer);

                    sendBroadcast(in);

                    text=Integer.toString(timer);
                    handler.post(doUpdateGUI);

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }


                }

            }

        });
        thread.start();




    }
    private Runnable doUpdateGUI = new Runnable() {
        public void run() {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    };








}
