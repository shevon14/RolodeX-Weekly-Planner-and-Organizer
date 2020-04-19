package com.example.dell.rolodex;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.drm.DrmStore;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Calendar;

public class OverviewActivity extends AppCompatActivity implements CustomAddPlanListAdapter.CheckboxCheckedListner {

    Database2_Activity myDB2;
    ArrayList<Plans>arrayList;
    ListView listPlans;
    CustomAddPlanListAdapter plansadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        listPlans = (ListView) findViewById(R.id.list_plan_view);
        myDB2 = new Database2_Activity(this);
        arrayList = new ArrayList<>();
        arrayList = myDB2.getAllData();
        plansadapter = new CustomAddPlanListAdapter(this, arrayList);
        listPlans.setAdapter(plansadapter);
        plansadapter.notifyDataSetChanged();
        plansadapter.setCheckedListner(this);
        plansadapter.setUncheckedListner(this);

        FloatingActionButton floatindaddbtn = (FloatingActionButton) findViewById(R.id.fab);

        floatindaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadaddplanctivity = new Intent(OverviewActivity.this, AddPlanActivity.class);
                startActivity(loadaddplanctivity);
            }
        });


        listPlans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent loadeditActivity = new Intent(OverviewActivity.this, EditPlanActivity.class);
                loadeditActivity.putExtra("ID", arrayList.get(position).id);
                loadeditActivity.putExtra("Description", arrayList.get(position).description);
                loadeditActivity.putExtra("Hour", arrayList.get(position).hour);
                loadeditActivity.putExtra("Minute", arrayList.get(position).minute);
                loadeditActivity.putExtra("SoundMode", arrayList.get(position).soundmode);
                loadeditActivity.putExtra("SUNDAY", arrayList.get(position).sunday);
                loadeditActivity.putExtra("MONDAY", arrayList.get(position).monday);
                loadeditActivity.putExtra("TUESDAY", arrayList.get(position).tuesday);
                loadeditActivity.putExtra("WEDNESDAY", arrayList.get(position).wednesday);
                loadeditActivity.putExtra("THURSDAY", arrayList.get(position).thursday);
                loadeditActivity.putExtra("FRIDAY", arrayList.get(position).friday);
                loadeditActivity.putExtra("SATURDAY", arrayList.get(position).saturday);
                loadeditActivity.putExtra("Position",position);
                startActivity(loadeditActivity);
            }
        });

        TextView emptytext = (TextView) findViewById(R.id.plansemptytext);
        listPlans.setEmptyView(emptytext);

    }

    @Override
    public void getCheckBoxCheckedListner(int position) {
           // Toast.makeText(getApplicationContext(),notifications,Toast.LENGTH_LONG).show();
            String notificationONOFFnew = "ON";
            myDB2.updateNotifcation(notificationONOFFnew,arrayList.get(position).id,arrayList.get(position).notifications);

        String SUN = "SUN "; String MON = "MON "; String TUE = "TUE "; String WED = "WED "; String THU = "THU ";
        String FRI = "FRI "; String SAT = "SAT ";
        if (SUN.equals(arrayList.get(position).sunday)) {
            setNotification(position,1);
        }
        if (MON.equals(arrayList.get(position).monday)){
            setNotification(position,2);
        }
        if (TUE.equals(arrayList.get(position).tuesday)){
            setNotification(position,3);
        }
        if (WED.equals(arrayList.get(position).wednesday)){
            setNotification(position,4);
        }
        if (THU.equals(arrayList.get(position).thursday)){
            setNotification(position,5);
        }
        if (FRI.equals(arrayList.get(position).friday)){
            setNotification(position,6);
        }
        if (SAT.equals(arrayList.get(position).saturday)){
            setNotification(position,7);
        }

    }

    @Override
    public void getUncheckBoxCheckedListner(int position) {
        //Toast.makeText(getApplicationContext(),notifications,Toast.LENGTH_LONG).show();
        String notificationONOFFnew = "OFF";
        myDB2.updateNotifcation(notificationONOFFnew,arrayList.get(position).id,arrayList.get(position).notifications);

        cancelNOtification(position);

    }

  public void setNotification(int i,int j){

      AlarmManager alarmManagers = (AlarmManager) getSystemService(ALARM_SERVICE);
      Intent intent = new Intent(OverviewActivity.this, AlarmReceiverActivity.class);

      int notiID = arrayList.get(i).id;

        //intent.putExtra("notificationsID",arrayList.get(i).id + "." + j);
        intent.putExtra("notificationID",notiID);
        intent.putExtra("todo",arrayList.get(i).description );
        intent.putExtra("SOUNDmode",arrayList.get(i).soundmode);

       PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(),notiID,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();

        Calendar startTime = Calendar.getInstance();

        startTime.set(Calendar.DAY_OF_WEEK,j);
        startTime.set(Calendar.HOUR_OF_DAY,arrayList.get(i).hour);
        startTime.set(Calendar.MINUTE,arrayList.get(i).minute);
        startTime.set(Calendar.SECOND,0);

        if (startTime.before(calendar)){
            startTime.add(Calendar.DATE,7);
        }

        long alamstarttime = startTime.getTimeInMillis();
        alarmManagers.setRepeating(AlarmManager.RTC_WAKEUP,alamstarttime,AlarmManager.INTERVAL_DAY,alarmIntent);
    }

    public void cancelNOtification(int i){

        AlarmManager alarmManagers = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(OverviewActivity.this, AlarmReceiverActivity.class);
        PendingIntent alarmIntent  = PendingIntent.getBroadcast(getApplicationContext(),arrayList.get(i).id,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManagers.cancel(alarmIntent);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_bttn,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == R.id.addplan){
            Intent loadaddplanctivity = new Intent(OverviewActivity.this, AddPlanActivity.class);
            startActivity(loadaddplanctivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        Intent loadHomeActivity = new Intent(OverviewActivity.this,MainActivity.class);
        startActivity(loadHomeActivity);
    }


}



