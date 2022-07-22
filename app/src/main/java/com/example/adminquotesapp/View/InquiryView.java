package com.example.adminquotesapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.adminquotesapp.Adapters.InquiryAdapter;
import com.example.adminquotesapp.Models.InquiryModel;
import com.example.adminquotesapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InquiryView extends AppCompatActivity
{
    ListView listView;
    List<InquiryModel> list;
    InquiryModel inquiryModel;
    InquiryAdapter adapter;
    DatabaseReference iReferance;
    ProgressBar iProgressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_view);

        listView=findViewById(R.id.inquiry_listview);
        iProgressbar=findViewById(R.id.inquiryviews_progressBar);

        iProgressbar.setVisibility(View.VISIBLE);
        list=new ArrayList<>();

        iReferance= FirebaseDatabase.getInstance().getReference("inquiry");

        iReferance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    inquiryModel=dataSnapshot.getValue(InquiryModel.class);
                    list.add(inquiryModel);
                }
                adapter=new InquiryAdapter(InquiryView.this,list);
                listView.setAdapter(adapter);
                iProgressbar.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }
}