package com.example.adminquotesapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.adminquotesapp.Models.ContactModel;
import com.example.adminquotesapp.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter
{
    Activity activity;
    List<ContactModel> list;

    public ContactAdapter( Activity activity, List<ContactModel> list)
    {
        super(activity, R.layout.layout_contact,list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(R.layout.layout_contact,null,true);

        TextView num1=convertView.findViewById(R.id.viewcontact_num1);
        TextView num2=convertView.findViewById(R.id.viewcontact_num2);
        TextView email=convertView.findViewById(R.id.viewcontact_email);
        TextView website=convertView.findViewById(R.id.viewcontact_website);
        TextView address=convertView.findViewById(R.id.viewcontact_address);

        ContactModel contactModel=list.get(position);

        num1.setText(contactModel.getNum1());
        num2.setText(contactModel.getNum2());
        email.setText(contactModel.getEmail());
        website.setText(contactModel.getWebsite());
        address.setText(contactModel.getAddress());

        return convertView;



    }
}
