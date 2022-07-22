package com.example.adminquotesapp.Insert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adminquotesapp.Models.ContactModel;
import com.example.adminquotesapp.R;
import com.example.adminquotesapp.View.ContactView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactInsert extends AppCompatActivity
{
    EditText num1,num2,email,website,address;
    Button insertcontact,viewcontactData;
    ProgressBar cProgressBar;
    DatabaseReference cReferance;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_insert);

        num1=findViewById(R.id.insert_contact1);
        num2=findViewById(R.id.insert_contact2);
        email=findViewById(R.id.insert_email);
        website=findViewById(R.id.insert_website);
        address=findViewById(R.id.insert_address);
        insertcontact=findViewById(R.id.insert_button);
        viewcontactData=findViewById(R.id.insert_viewdata_button);

        cProgressBar=findViewById(R.id.contactUSProgress);

        cReferance= FirebaseDatabase.getInstance().getReference("Contactus");

        insertcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NUM1 = num1.getText().toString().trim();
                String NUM2 = num2.getText().toString().trim();
                String EMAIL = email.getText().toString().trim();
                String WEBSITE = website.getText().toString().trim();
                String ADDRESS = address.getText().toString().trim();

                if (NUM1.isEmpty()) {
                    num1.setError("Please enter num 1");
                    num1.requestFocus();
                    return;
                }

                if (NUM2.isEmpty()) {
                    num2.setError("Please enter num 2");
                    num2.requestFocus();
                    return;
                }

                if (EMAIL.isEmpty()) {
                    email.setError("Please enter email");
                    email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(EMAIL).matches()) {
                    email.setError("Email is not valid");
                    email.requestFocus();
                    return;
                }

                if (WEBSITE.isEmpty()) {
                    website.setError("Please enter website");
                    website.requestFocus();
                    return;
                }

                if (ADDRESS.isEmpty()) {
                    address.setError("Please enter address");
                    address.requestFocus();
                    return;
                }

                cProgressBar.setVisibility(View.VISIBLE);
                insertcontact.setVisibility(View.GONE);

                String Id=cReferance.push().getKey();
                ContactModel contactModel = new ContactModel(Id, NUM1, NUM2, EMAIL, WEBSITE, ADDRESS);

                cReferance.child(Id).setValue(contactModel).addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(ContactInsert.this, "Data inserted", Toast.LENGTH_SHORT).show();
                            cProgressBar.setVisibility(View.GONE);
                            insertcontact.setVisibility(View.VISIBLE);

                            num1.setText("");
                            num2.setText("");
                            email.setText("");
                            website.setText("");
                            address.setText("");
                        }

                    }
                }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(ContactInsert.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        cProgressBar.setVisibility(View.GONE);
                        insertcontact.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }

    public void ContactViewData(View view)
    {
        startActivity(new Intent(ContactInsert.this,ContactView.class));
    }
}