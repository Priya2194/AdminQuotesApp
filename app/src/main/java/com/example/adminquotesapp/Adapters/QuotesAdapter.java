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

import com.example.adminquotesapp.Models.AboutModel;
import com.example.adminquotesapp.Models.QuotesModel;
import com.example.adminquotesapp.R;

import java.util.List;

public class QuotesAdapter extends ArrayAdapter
{

    Activity activity;
    List<QuotesModel> list;

    public QuotesAdapter( Activity activity, List<QuotesModel> list) {
        super(activity,R.layout.layout_vmotivational,list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView =layoutInflater.inflate(R.layout.layout_vmotivational,null,true);

        TextView line=convertView.findViewById(R.id.v_motivational);

        QuotesModel quotesModel= list.get(position);
        line.setText(quotesModel.getQuote());

        return  convertView;

    }
}
