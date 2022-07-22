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

import com.example.adminquotesapp.Models.InquiryModel;
import com.example.adminquotesapp.R;

import java.util.List;

public class InquiryAdapter extends ArrayAdapter
{
    Activity activity;
    List<InquiryModel> list;

    public InquiryAdapter( Activity activity, List<InquiryModel> list) {
        super(activity, R.layout.layout_inquiry,list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(R.layout.layout_inquiry,null,true);


        TextView iName,iEmail,iContact,iAsk,iFeedback;
         iName=convertView.findViewById(R.id.inquirynm);
         iEmail=convertView.findViewById(R.id.inquiryemail);
         iContact=convertView.findViewById(R.id.inquirycontact);
         iAsk=convertView.findViewById(R.id.inquiryaskanything);
         iFeedback=convertView.findViewById(R.id.inquiryfeedback);

         InquiryModel inquiryModel=list.get(position);

         iName.setText(inquiryModel.getName());
         iEmail.setText(inquiryModel.getEmail());
         iContact.setText(inquiryModel.getContact());
         iAsk.setText(inquiryModel.getAsk());
         iFeedback.setText(inquiryModel.getFeedback());

         return convertView;


    }
}
