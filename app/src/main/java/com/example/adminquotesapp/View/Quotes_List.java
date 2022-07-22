package com.example.adminquotesapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adminquotesapp.R;

public class Quotes_List extends AppCompatActivity
{
    ListView listView;
    ArrayAdapter arrayAdapter;

    String string[] = {"VMotivational", "VInspirational", "VSuccess", "VPositive", "VLeaderShip", "VLife", "VLove", "VAttitude", "VChange", "VPatience", "VPeace", "VEducation", "VRelationship", "VFailure", "VFaith", "VPower", "VFriendShip", "VHappiness", "VHealth", "VTrust1"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);

        listView=findViewById(R.id.quotesAllListView);

        arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,string);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String pos=string[position];
                try {

                    Class cls=Class.forName("com.example.adminquotesapp.View." + pos);
                    startActivity(new Intent(Quotes_List.this,cls));

                }
                catch (ClassNotFoundException e)
                {

                }

            }
        });
    }
}