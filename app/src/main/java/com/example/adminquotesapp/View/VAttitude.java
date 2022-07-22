package com.example.adminquotesapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.adminquotesapp.Adapters.QuotesAdapter;
import com.example.adminquotesapp.Models.QuotesModel;
import com.example.adminquotesapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VAttitude extends AppCompatActivity
{
    ListView listView;
    List<QuotesModel> list;
    ProgressBar aProgressbar;
    Query dbReferance;
    QuotesModel quotesModel;
    QuotesAdapter quotesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vattitude);

        listView=findViewById(R.id.v_listview_attitude);
        aProgressbar=findViewById(R.id.pro_attitude);

        list=new ArrayList<>();
        aProgressbar.setVisibility(View.VISIBLE);

        dbReferance= FirebaseDatabase.getInstance().getReference("quotes").orderByChild("qt_cat").equalTo("Attitude");

        dbReferance.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                list.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    quotesModel=dataSnapshot.getValue(QuotesModel.class);
                    list.add(quotesModel);

                }
                quotesAdapter=new QuotesAdapter(VAttitude.this,list);
                listView.setAdapter(quotesAdapter);
                aProgressbar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });

    }
}