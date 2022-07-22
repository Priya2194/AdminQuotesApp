package com.example.adminquotesapp.Insert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adminquotesapp.Models.AboutModel;
import com.example.adminquotesapp.R;
import com.example.adminquotesapp.View.AboutView;
import com.example.adminquotesapp.View.AboutViewData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AboutInsert extends AppCompatActivity
{
    EditText line1,line2,line3,line4,line5;
    Button buttonInsert,viewAboutdata;
    DatabaseReference reference;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_insert);

        line1=findViewById(R.id.aboutusline1);
        line2=findViewById(R.id.aboutusline2);
        line3=findViewById(R.id.aboutusline3);
        line4=findViewById(R.id.aboutusline4);
        line5=findViewById(R.id.aboutusline5);
        buttonInsert=findViewById(R.id.aboutInsertButton);
        viewAboutdata=findViewById(R.id.viewAboutdata);
        progressBar=findViewById(R.id.aboutProg);

        reference= FirebaseDatabase.getInstance().getReference("AboutUs");

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Line1=line1.getText().toString();
                String Line2=line2.getText().toString();
                String Line3=line3.getText().toString();
                String Line4=line4.getText().toString();
                String Line5=line5.getText().toString();

                if (Line1.isEmpty())
                {
                    line1.setError("Please insert content");
                    line1.requestFocus();
                }

                if (Line2.isEmpty())
                {
                    line2.setError("Please insert content");
                    line2.requestFocus();
                }
                if (Line3.isEmpty())
                {
                    line3.setError("Please insert content");
                    line3.requestFocus();
                }
                if (Line4.isEmpty())
                {
                    line4.setError("Please insert content");
                    line4.requestFocus();
                }
                if (Line5.isEmpty())
                {
                    line5.setError("Please insert content");
                    line5.requestFocus();
                }

                buttonInsert.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                String Id=reference.push().getKey();

                AboutModel aboutModel=new  AboutModel(Id,Line1,Line2,Line3,Line4,Line5);

                reference.child(Id).setValue(aboutModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(AboutInsert.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            buttonInsert.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(AboutInsert.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        buttonInsert.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });



    }

    public void OpenAboutViewData(View view)
    {
        startActivity(new Intent(AboutInsert.this, AboutView.class));

    }
}