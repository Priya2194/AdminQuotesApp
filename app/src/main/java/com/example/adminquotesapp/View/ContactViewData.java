package com.example.adminquotesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adminquotesapp.R;

public class ContactViewData extends AppCompatActivity
{
    private TextView num1, num2, email, website, address;

    private static final String NUM1_KEY = "com.example.adminquotesapp.NUM1_";
    private static final String NUM2_KEY = "com.example.adminquotesapp.NUM2_";
    private static final String EMAIL_KEY = "com.example.adminquotesapp.EMAIL_";
    private static final String WEBSITE_KEY = "com.example.adminquotesapp.WEBSITE_";
    private static final String ADDRESS_KEY = "com.example.adminquotesapp.ADDRESS_";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view_data);

        num1 = findViewById(R.id.viewNum1);
        num2 = findViewById(R.id.viewNum2);
        email = findViewById(R.id.viewEmail);
        website = findViewById(R.id.viewWebsite);
        address = findViewById(R.id.viewAddress);

        Intent intent = getIntent();

        String NUM1 = intent.getStringExtra(NUM1_KEY);
        String NUM2 = intent.getStringExtra(NUM2_KEY);
        String EMAIL = intent.getStringExtra(EMAIL_KEY);
        String WEBSITE = intent.getStringExtra(WEBSITE_KEY);
        String ADDRESS = intent.getStringExtra(ADDRESS_KEY);

        num1.setText(NUM1);
        num2.setText(NUM2);
        email.setText(EMAIL);
        website.setText(WEBSITE);
        address.setText(ADDRESS);

    }
}