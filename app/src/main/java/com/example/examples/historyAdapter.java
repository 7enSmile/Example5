package com.example.examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class historyAdapter extends ArrayAdapter<historyItem> {
    private Context mContext;
    int mResource;
    ArrayList<historyItem> history;

    public historyAdapter(Context context, int resource, ArrayList<historyItem> objects){
        super(context,resource,objects);
        mContext=context;
        mResource=resource;
        history=objects;
    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        final Button historyButton;
        String text=getItem(position).historyText;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvText=(TextView)convertView.findViewById(R.id.textView);
        historyButton = convertView.findViewById(R.id.button2);
        final Button historyButton2 = convertView.findViewById(R.id.button3);
        historyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer count = parent.getChildCount();
                        for (int i = 0; i < count; i++) {
                            if(i!=position) {
                                View child = parent.getChildAt(i);
                                child.setVisibility(View.INVISIBLE);
                            }
                        }






                    }
                }
        );
        historyButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer count = parent.getChildCount();
                        for (int i = 0; i < count; i++) {
                            if(i!=position) {
                                View child = parent.getChildAt(i);
                                child.setVisibility(View.VISIBLE);
                            }
                        }






                    }
                }
        );
        tvText.setText(text);
        return convertView;
    }


}
