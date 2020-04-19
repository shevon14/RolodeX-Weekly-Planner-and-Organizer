package com.example.dell.rolodex;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class AddPlanActivity extends AppCompatActivity {

    Database2_Activity myDB2;
    boolean isClickedbtn;
    String isbtnclickS; String isbtnclickM; String isbtnclickTU; String isbtnclickW; String isbtnclickTH; String isbtnclickF; String isbtnclickSA;
    EditText descriptiontype;
    TimePicker timePicker;

    Button soundmodebtn;
    Button silentmodebtn;
    Button vibratemodebtn;

    String selectedSoundMode;
    //String selectedDays;
    String SUNDAY = ""; String MONDAY = ""; String TUESDAY = ""; String WEDNESDAY = ""; String THURSDAY = ""; String FRIDAY = ""; String SATURDAY = "";
    Button daybtn1; Button daybtn2; Button  daybtn3; Button daybtn4; Button daybtn5; Button daybtn6; Button daybtn7;

    //final ArrayList<String> dayselected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        myDB2 = new Database2_Activity(this);

        descriptiontype = (EditText) findViewById(R.id.txtdestype);

         daybtn1 = (Button) findViewById(R.id.Sunday);
         daybtn2 = (Button) findViewById(R.id.Monday);
         daybtn3 = (Button) findViewById(R.id.Tuesday);
         daybtn4 = (Button) findViewById(R.id.Wednesday);
         daybtn5 = (Button) findViewById(R.id.Thursay);
         daybtn6 = (Button) findViewById(R.id.Friday);
         daybtn7 = (Button) findViewById(R.id.Saturday);

        isbtnclickS = "Y"; isbtnclickM = "Y"; isbtnclickTU = "Y"; isbtnclickW = "Y"; isbtnclickTH = "Y";  isbtnclickF = "Y"; isbtnclickSA = "Y";


        daybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sundayclick = "Y";
                if(sundayclick.equals(isbtnclickS)) {
                    v.setBackgroundResource(R.drawable.round_selected_button);
                    SUNDAY = "SUN ";
                    isbtnclickS = "N";
                }
                else {
                    v.setBackgroundResource(R.drawable.round_button);
                    SUNDAY = "";
                    isbtnclickS = "Y";
                }

            }
        });

        daybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mondayClick = "Y";
                if(mondayClick.equals(isbtnclickM)) {
                    MONDAY = "MON ";
                    v.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickM = "N";
                } else {
                    v.setBackgroundResource(R.drawable.round_button);
                    MONDAY = "";
                    isbtnclickM = "Y";
                }
            }
        });

        daybtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tuesdayclick = "Y";
                if(tuesdayclick.equals(isbtnclickTU)) {
                    TUESDAY = "TUE ";
                    daybtn3.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickTU = "N";
                } else {
                    daybtn3.setBackgroundResource(R.drawable.round_button);
                    TUESDAY = "";
                    isbtnclickTU = "Y";
                }
            }
        });

        daybtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wednesdayclick = "Y";
                if(wednesdayclick.equals(isbtnclickW)) {
                    WEDNESDAY = "WED ";
                    daybtn4.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickW = "N";
                } else {
                    WEDNESDAY = "";
                    daybtn4.setBackgroundResource(R.drawable.round_button);
                    isbtnclickW = "Y";
                }
            }
        });

        daybtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thursdayclick = "Y";
                if(thursdayclick.equals(isbtnclickTH)) {
                    THURSDAY = "THU ";
                    daybtn5.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickTH = "N";
                } else {
                    THURSDAY= "";
                    daybtn5.setBackgroundResource(R.drawable.round_button);
                    isbtnclickTH = "Y";
                }

            }
        });

        daybtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fridayclick = "Y";
                if(fridayclick.equals(isbtnclickF)) {
                    FRIDAY = "FRI ";
                    daybtn6.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickF = "N";
                } else {
                    FRIDAY = "";
                    daybtn6.setBackgroundResource(R.drawable.round_button);
                    isbtnclickF = "Y";
                }
            }
        });

        daybtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saturdayclick = "Y";
                if(saturdayclick.equals(isbtnclickSA)) {
                    SATURDAY = "SAT ";
                    daybtn7.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickSA = "N";
                } else {
                    SATURDAY ="";
                    daybtn7.setBackgroundResource(R.drawable.round_button);
                    isbtnclickSA = "Y";
                }
            }
        });

        timePicker = (TimePicker) findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);

        soundmodebtn = (Button) findViewById(R.id.soundmode);
        silentmodebtn = (Button) findViewById(R.id.Silentmode);
        vibratemodebtn = (Button) findViewById(R.id.vibratemode);

       soundmodebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               isClickedbtn = true;
               if(isClickedbtn) {
                   isClickedbtn = false;
                   selectedSoundMode = "SOUND";
                   soundmodebtn.setBackgroundResource(R.drawable.round_selected_button);
                   vibratemodebtn.setBackgroundResource(R.drawable.round_button);
                   silentmodebtn.setBackgroundResource(R.drawable.round_button);

               } else {
                   isClickedbtn = true;
                   soundmodebtn.setBackgroundResource(R.drawable.round_button);
                   selectedSoundMode = null;
               }
           }
       });

       vibratemodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickedbtn = true;
                if(isClickedbtn) {
                    isClickedbtn = false;
                    selectedSoundMode = "VIBRATE";
                    vibratemodebtn.setBackgroundResource(R.drawable.round_selected_button);
                    silentmodebtn.setBackgroundResource(R.drawable.round_button);
                    soundmodebtn.setBackgroundResource(R.drawable.round_button);

                } else {
                    isClickedbtn = true;
                   vibratemodebtn.setBackgroundResource(R.drawable.round_button);
                    selectedSoundMode = null;
                }
            }
        });

        silentmodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickedbtn = true;
                if(isClickedbtn) {
                    isClickedbtn = false;
                    selectedSoundMode = "SILENT";
                    silentmodebtn.setBackgroundResource(R.drawable.round_selected_button);
                    vibratemodebtn.setBackgroundResource(R.drawable.round_button);
                    soundmodebtn.setBackgroundResource(R.drawable.round_button);

                } else {
                    isClickedbtn = true;
                    silentmodebtn.setBackgroundResource(R.drawable.round_button);
                    selectedSoundMode = null;
                }
            }
        });


    }


    public void AddData(){

        String description;
        String descriptionType =descriptiontype.getText().toString() ;
        if (descriptionType.isEmpty()){
            description = "No Description";
        } else {
            description = descriptionType;
        }

        String sunday = SUNDAY; String monday = MONDAY; String tuesday = TUESDAY; String wednesday = WEDNESDAY; String thursday = THURSDAY;
        String friday = FRIDAY; String saturday = SATURDAY;
        Integer hour = timePicker.getCurrentHour();
        Integer minute = timePicker.getCurrentMinute();
        String soundmode = selectedSoundMode ;
        String notifications = "ON";

        if (description.isEmpty() || soundmode == null || (sunday.isEmpty() && monday.isEmpty() && tuesday.isEmpty() && wednesday.isEmpty() && thursday.isEmpty() && friday.isEmpty() && saturday.isEmpty()) ) {
            Toast.makeText(getApplicationContext(),"Plan not recorded, Please fill every details",Toast.LENGTH_LONG).show();

        }else {
            boolean insertData = myDB2.addData(description,hour,minute, soundmode,sunday,monday,tuesday,wednesday,thursday,friday,saturday,notifications);
            if (insertData == true) {
                Toast.makeText(AddPlanActivity.this, "Successfully Entered the Data", Toast.LENGTH_LONG).show();
            } else {

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_button, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.savebttn) {

            AddData();

            Intent loadoverviewactivity = new Intent(AddPlanActivity.this, OverviewActivity.class);
            startActivity(loadoverviewactivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}



