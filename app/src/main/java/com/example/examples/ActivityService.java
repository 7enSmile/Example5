package com.example.examples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class ActivityService extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_service);
        super.onCreate(savedInstanceState);
    }
    public void onClickStart(View v){


        startService(new Intent(this,SomeService.class));
    }
    public void onClickStop(View v){
        stopService(new Intent(this,SomeService.class));
    }

}