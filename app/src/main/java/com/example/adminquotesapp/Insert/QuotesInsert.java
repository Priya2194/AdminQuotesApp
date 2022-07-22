package com.example.adminquotesapp.Insert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adminquotesapp.Models.QuotesModel;
import com.example.adminquotesapp.R;
import com.example.adminquotesapp.View.Quotes_List;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuotesInsert extends AppCompatActivity
{
    EditText qt_cat, qt_qt;
    Spinner spinner_cat;
    Button quotesbtn;
    ProgressBar qProgreassbar;
    DatabaseReference qReferance;
    String mystring[];
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_insert);

        qt_cat=findViewById(R.id.qt_cat_id);
        qt_qt=findViewById(R.id.qt_qt);
        spinner_cat=findViewById(R.id.qt_cat);
        quotesbtn=findViewById(R.id.insert_quote_button);
        qProgreassbar=findViewById(R.id.qt_pro);

        qReferance= FirebaseDatabase.getInstance().getReference("quotes");
        mystring=getResources().getStringArray(R.array.quotes_category);
        arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,mystring);
        spinner_cat.setAdapter(arrayAdapter);

        spinner_cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                String pos=mystring[position];

                switch (pos)
                {
                    case "Motivation":
                        qt_cat.setText("1");
                        break;

                    case "Inspiration":
                        qt_cat.setText("2");
                        break;

                    case "Success":
                        qt_cat.setText("3");
                        break;

                    case "Positive":
                        qt_cat.setText("4");
                        break;

                    case "Leadership":
                        qt_cat.setText("5");
                        break;

                    case "Life":
                        qt_cat.setText("6");
                        break;

                    case "Love":
                        qt_cat.setText("7");
                        break;

                    case "Attitude":
                        qt_cat.setText("8");
                        break;

                    case "Change":
                        qt_cat.setText("9");
                        break;

                    case "Patience":
                        qt_cat.setText("10");
                        break;

                    case "Peace":
                        qt_cat.setText("11");
                        break;

                    case "Education":
                        qt_cat.setText("12");
                        break;

                    case "Relationship":
                        qt_cat.setText("13");
                        break;

                    case "Failure":
                        qt_cat.setText("14");
                        break;

                    case "Faith":
                        qt_cat.setText("15");
                        break;

                    case "Power":
                        qt_cat.setText("16");
                        break;

                    case "Friendship":
                        qt_cat.setText("17");
                        break;

                    case "Happiness":
                        qt_cat.setText("18");
                        break;

                    case "Health":
                        qt_cat.setText("19");
                        break;

                    case "Trust":
                        qt_cat.setText("20");
                        break;
                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        quotesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String CAT_ID = qt_cat.getText().toString();
                String CAT = spinner_cat.getSelectedItem().toString();
                String QUOTE = qt_qt.getText().toString();

                if (CAT_ID.isEmpty()) {
                    qt_cat.setError("Please enter ID");
                    qt_cat.requestFocus();
                    return;
                }


                if (QUOTE.isEmpty()) {
                    qt_qt.setError("Please enter quote");
                    qt_qt.requestFocus();
                    return;
                }

                qProgreassbar.setVisibility(View.VISIBLE);
                quotesbtn.setVisibility(View.GONE);

                String ID = qReferance.push().getKey();

                QuotesModel quotesModel = new QuotesModel(ID, CAT_ID, CAT, QUOTE);

                qReferance.child(ID).setValue(quotesModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(QuotesInsert.this, "Data inserted", Toast.LENGTH_SHORT).show();
                            qProgreassbar.setVisibility(View.GONE);
                            quotesbtn.setVisibility(View.VISIBLE);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(QuotesInsert.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        qProgreassbar.setVisibility(View.GONE);
                        quotesbtn.setVisibility(View.VISIBLE);
                    }
                });

            }
        });
    }


    public void viewQuoteList(View view)
    {
        startActivity(new Intent(QuotesInsert.this, Quotes_List.class));
    }
}