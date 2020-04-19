package com.example.dell.rolodex;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomSPListAdapter extends BaseAdapter {

    Context context;
    ArrayList<Notes> arrayList;

    public CustomSPListAdapter( Context context, ArrayList<Notes> arrayList ){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listspecilanoteview,null);
        TextView txtNote = (TextView)convertView.findViewById(R.id.SNdescription);

        Notes notes = arrayList.get(position);

        txtNote.setText(notes.getNotedescription());

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }


}
