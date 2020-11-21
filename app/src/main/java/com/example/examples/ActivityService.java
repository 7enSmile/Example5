package com.example.examples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class ActivityService extends AppCompatActivity {
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_service);
        progressBar=(ProgressBar)findViewById(R.id.progressBar4);
        super.onCreate(savedInstanceState);



    }

    public void onClickStart(View v){

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("progress");
        BroadcastReceiver receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              if(intent.getAction().equals("progress")){
                  progressBar.setProgress(intent.getIntExtra("Progress",0));
              }
            }
        };
        registerReceiver(receiver,intentFilter);


        startService(new Intent(this,SomeService.class));

    }
    public void onClickStop(View v){

        stopService(new Intent(this,SomeService.class));
    }





}
