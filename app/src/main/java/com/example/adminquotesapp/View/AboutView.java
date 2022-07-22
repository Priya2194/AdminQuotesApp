package com.example.adminquotesapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adminquotesapp.Adapters.AboutAdapter;
import com.example.adminquotesapp.Models.AboutModel;
import com.example.adminquotesapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AboutView extends AppCompatActivity
{
    ListView listView;
    List<AboutModel> list;
    AboutModel aboutModel;
    AboutAdapter aboutAdapter;
    DatabaseReference aReference;

    private static final String Line_key1="com.example.adminquotesapp.Line1";
    private static final String Line_key2="com.example.adminquotesapp.Line2";
    private static final String Line_key3="com.example.adminquotesapp.Line3";
    private static final String Line_key4="com.example.adminquotesapp.Line4";
    private static final String Line_key5="com.example.adminquotesapp.Line5";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view);

        listView=findViewById(R.id.aboutListView1);
        list=new ArrayList<>();

        aReference= FirebaseDatabase.getInstance().getReference("AboutUs");

        aReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    aboutModel=dataSnapshot.getValue(AboutModel.class);
                    list.add(aboutModel);
                }
                aboutAdapter=new AboutAdapter(AboutView.this,list);
                listView.setAdapter(aboutAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                    AboutModel aboutModel=list.get(position);
                Intent intent=new Intent(AboutView.this,AboutViewData.class);
                intent.putExtra(Line_key1,aboutModel.getLine1());
                intent.putExtra(Line_key2,aboutModel.getLine2());
                intent.putExtra(Line_key3,aboutModel.getLine3());
                intent.putExtra(Line_key4,aboutModel.getLine4());
                intent.putExtra(Line_key5,aboutModel.getLine5());
                startActivity(intent);

            }
        });
    }
}