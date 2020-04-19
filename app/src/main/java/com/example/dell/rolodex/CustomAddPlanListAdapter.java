package com.example.dell.rolodex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.IllegalCharsetNameException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CustomAddPlanListAdapter extends BaseAdapter{

   Context context;
   ArrayList<Plans> arrayList;
   Switch btn;
   private CheckboxCheckedListner checkedListner;

    public CustomAddPlanListAdapter( Context context, ArrayList<Plans> arrayList){
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
    public View getView(final int position, View convertView, ViewGroup parent) {


            final LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listplanview,null);
            final TextView txtxPaln = (TextView)convertView.findViewById(R.id.plandescriptionview);
            TextView txtTime = (TextView)convertView.findViewById(R.id.timeview);
            TextView txtSound = (TextView)convertView.findViewById(R.id.SOUNDview);
            TextView txtdays = (TextView)convertView.findViewById(R.id.SUNview);
            btn = (Switch) convertView.findViewById(R.id.switchbtn);

            final Plans plans = arrayList.get(position);

            txtxPaln.setText(plans.getDescription());
        NumberFormat f = new DecimalFormat("00");
        txtTime.setText(f.format(plans.getHour())+":"+f.format(plans.getMinute()));
            txtSound.setText(plans.getSoundmode());
            txtdays.setText(plans.getSunday()+plans.getMonday()+plans.getTuesday()+plans.getWednesday()+plans.getThursday()+plans.getFriday()+plans.getSaturday());

            String notificationONOF = plans.notifications;

            if (notificationONOF.equals("ON")){
                btn.setChecked(true);
            } else {
                btn.setChecked(false);
            }

            if (btn.isChecked()){
                checkedListner.getCheckBoxCheckedListner(position);
            }
            else {
                checkedListner.getUncheckBoxCheckedListner(position);
            }

           btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        checkedListner.getCheckBoxCheckedListner(position);

                    } else {
                        checkedListner.getUncheckBoxCheckedListner(position);
                    }
                }
            });

            return convertView;
    }

    public interface CheckboxCheckedListner{

        void getCheckBoxCheckedListner(int position);
        void getUncheckBoxCheckedListner(int position);
    }

    public void setCheckedListner(CheckboxCheckedListner checkedListner){
        this.checkedListner = checkedListner;
    }
    public void setUncheckedListner(CheckboxCheckedListner checkedListner){
        this.checkedListner = checkedListner;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }


}
