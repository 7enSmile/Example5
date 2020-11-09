package com.example.examples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        Intent intent = getIntent();

        ListView mListView =(ListView)findViewById(R.id.lisHistory);

        historyAdapter adapter=new historyAdapter(this,R.layout.history_item,intent.<historyItem>getParcelableArrayListExtra("history"));
        mListView.setAdapter(adapter);
    }


}