package com.example.adminquotesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adminquotesapp.R;

public class AboutViewData extends AppCompatActivity {

    private TextView line1, line2, line3, line4, line5;

    private static final String Line_key1="com.example.adminquotesapp.Line1_";
    private static final String Line_key2="com.example.adminquotesapp.Line2_";
    private static final String Line_key3="com.example.adminquotesapp.Line3_";
    private static final String Line_key4="com.example.adminquotesapp.Line4_";
    private static final String Line_key5="com.example.adminquotesapp.Line5_";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view_data);

        line1=findViewById(R.id.viewLine1);
        line2=findViewById(R.id.viewLine2);
        line3=findViewById(R.id.viewLine3);
        line4=findViewById(R.id.viewLine4);
        line5=findViewById(R.id.viewLine5);

        Intent intent=getIntent();

        String LINE1=intent.getStringExtra(Line_key1);
        String LINE2=intent.getStringExtra(Line_key2);
        String LINE3=intent.getStringExtra(Line_key3);
        String LINE4=intent.getStringExtra(Line_key4);
        String LINE5=intent.getStringExtra(Line_key5);

        line1.setText(LINE1);
        line2.setText(LINE2);
        line3.setText(LINE3);
        line4.setText(LINE4);
        line5.setText(LINE5);


    }
}