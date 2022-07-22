package com.example.adminquotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adminquotesapp.Insert.AboutInsert;
import com.example.adminquotesapp.Insert.ContactInsert;
import com.example.adminquotesapp.Insert.QuotesInsert;
import com.example.adminquotesapp.View.InquiryView;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void ContactUs(View view)
    {
            startActivity(new Intent(MainActivity.this, ContactInsert.class));

    }

    public void AboutUs(View view)
    {
            startActivity(new Intent(MainActivity.this, AboutInsert.class));
    }

    public void Quotes(View view)
    {
        startActivity(new Intent(MainActivity.this, QuotesInsert.class));

    }

    public void InsertImgQuotes(View view)
    {
        startActivity(new Intent(MainActivity.this,ImageInsert.class));
    }

    public void ViewInquiry(View view)
    {
        startActivity(new Intent(MainActivity.this, InquiryView.class));
    }
}