package com.example.dell.rolodex;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.acl.Group;

public class CustomListAdapter extends ArrayAdapter <String> {

    private Activity context;
    private String [] itemname;
    private Integer [] imageid;

    public CustomListAdapter(Activity context,String[] itemname, Integer [] imageid){
        super(context,R.layout.listview,itemname);
        this.context = context;
        this.itemname = itemname;
        this.imageid = imageid;
    }

    public View getView (int Position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.listview,null,true);
        TextView txtTitle = (TextView) rowview.findViewById(R.id.listtxt);
        ImageView imageView = (ImageView) rowview.findViewById(R.id.listimage);
        txtTitle.setText(itemname[Position]);
        imageView.setImageResource(imageid[Position]);
        return rowview;
    };

}
