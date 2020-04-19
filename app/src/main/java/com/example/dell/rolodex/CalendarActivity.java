package com.example.dell.rolodex;

import android.Manifest;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        EnableRuntimepermission();

        calendarView = (CalendarView) findViewById(R.id.calendarview);
        dateView = (TextView) findViewById(R.id.dateview);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                //dateView.setText(date);

                Calendar cal = Calendar.getInstance();
                Intent loadgooglecalendar = new Intent(Intent.ACTION_EDIT);
                loadgooglecalendar.setType("vnd.android.cursor.item/event");
                loadgooglecalendar.putExtra("beginTime", cal.getTimeInMillis());
                loadgooglecalendar.putExtra("allDay", false);
                loadgooglecalendar.putExtra("rrule", "FREQ=YEARLY");
                loadgooglecalendar.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                startActivity(loadgooglecalendar);
            }
        });

        Button btn1 = (Button) findViewById(R.id.CalendarAddPlan);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadAddPlanActivity = new Intent(CalendarActivity.this,AddPlanActivity.class);
                startActivity(loadAddPlanActivity);
            }
        });

        TextView acesstext = (TextView) findViewById(R.id.MobileAcess);

       /* Button btn2 = (Button) findViewById(R.id.MobileAcess);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(Intent.CATEGORY_APP_CALENDAR, CalendarContract.Calendars.CONTENT_URI);
               // startActivityForResult(intent, PICK_CALENDAR);

                Calendar cal = Calendar.getInstance();
                Intent loadgooglecalendar = new Intent(Intent.ACTION_EDIT);
                loadgooglecalendar.setType("vnd.android.cursor.item/event");
                loadgooglecalendar.putExtra("beginTime", cal.getTimeInMillis());
                loadgooglecalendar.putExtra("allDay", true);
                loadgooglecalendar.putExtra("rrule", "FREQ=YEARLY");
                loadgooglecalendar.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                startActivity(loadgooglecalendar);
            }
        }); */



    }

     public void EnableRuntimepermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(CalendarActivity.this, Manifest.permission.READ_CALENDAR)) {
            Toast.makeText(CalendarActivity.this, "CALENDAR permission allows us to Access CALENDAR app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(CalendarActivity.this, new String[]{Manifest.permission.READ_CALENDAR}, 100);
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(CalendarActivity.this, Manifest.permission.WRITE_CALENDAR)) {
            Toast.makeText(CalendarActivity.this, "CALENDAR permission allows us to Access CALENDAR app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(CalendarActivity.this, new String[]{Manifest.permission.WRITE_CALENDAR}, 100);
        }
    }

}
