package com.example.dell.rolodex;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditPlanActivity extends AppCompatActivity {

    Database2_Activity myDB2;
    OverviewActivity overviewActivity;
    private int ID;
    EditText editText;
    TimePicker timePicker;
    private String description;
    private Integer timeH;
    private Integer timeM;
    private String selectedbtn;
    Button daybtn1; Button daybtn2; Button  daybtn3; Button daybtn4; Button daybtn5; Button daybtn6; Button daybtn7;
    private String sunday; String monday; String tuesday; String wednesday; String thursday; String friday; String satueday;
    String newSoundMode;
    Boolean isClickedbtn;
    String isbtnclickS; String isbtnclickM; String isbtnclickTU; String isbtnclickW; String isbtnclickTH; String isbtnclickF; String isbtnclickSA;
    String newsunday = ""; String newmonday = ""; String newtuesday = ""; String newwednesday = "";
    String newthursday = ""; String newfriday = ""; String newsaturday = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        myDB2 = new Database2_Activity(this);

        Intent fromOverviewData = getIntent();

        ID = fromOverviewData.getIntExtra("ID",-1);
        //Toast.makeText(getApplicationContext(),ID,Toast.LENGTH_LONG).show();


        description = fromOverviewData.getStringExtra("Description");
        editText = (EditText) findViewById(R.id.Edittxtdestype);
        editText.setText(description);

        timePicker = (TimePicker) findViewById(R.id.Edittimepicker);
        timePicker.setIs24HourView(true);
        timeH = fromOverviewData.getIntExtra("Hour",12);
        timeM = fromOverviewData.getIntExtra("Minute",00);
        timePicker.setCurrentHour(timeH);
        timePicker.setCurrentMinute(timeM);

        final Button Editsound = (Button) findViewById(R.id.Esoundmode);
        final Button EditVibrate = (Button) findViewById(R.id.Evibratemode);
        final Button EditSilent = (Button) findViewById(R.id.ESilentmode);

        selectedbtn = fromOverviewData.getStringExtra("SoundMode");

            String sound = "SOUND"; String  vibrate = "VIBRATE"; String silent = "SILENT";

            if (sound.equals(selectedbtn)){
                Editsound.setBackgroundResource(R.drawable.round_selected_button);
                newSoundMode = "SOUND";
            }

            if (vibrate.equals(selectedbtn)){
                EditVibrate.setBackgroundResource(R.drawable.round_selected_button);
                newSoundMode = "VIBRATE";
            }

            if (silent.equals(selectedbtn)){
                EditSilent.setBackgroundResource(R.drawable.round_selected_button);
                newSoundMode = "SILENT";
            }

            Editsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isClickedbtn = true;
                    if(isClickedbtn) {
                        isClickedbtn = false;
                        newSoundMode = "SOUND";
                        Editsound.setBackgroundResource(R.drawable.round_selected_button);
                        EditVibrate.setBackgroundResource(R.drawable.round_button);
                        EditSilent.setBackgroundResource(R.drawable.round_button);

                    } else {
                        isClickedbtn = true;
                        Editsound.setBackgroundResource(R.drawable.round_button);
                        newSoundMode = null;
                    }
                }
            });

            EditVibrate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isClickedbtn = true;
                    if(isClickedbtn) {
                        isClickedbtn = false;
                        newSoundMode = "VIBRATE";
                        Editsound.setBackgroundResource(R.drawable.round_button);
                        EditVibrate.setBackgroundResource(R.drawable.round_selected_button);
                        EditSilent.setBackgroundResource(R.drawable.round_button);

                    } else {
                        isClickedbtn = true;
                        EditVibrate.setBackgroundResource(R.drawable.round_button);
                        newSoundMode = null;
                    }
                }

            });

            EditSilent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isClickedbtn = true;
                    if(isClickedbtn) {
                        isClickedbtn = false;
                        newSoundMode = "SILENT";
                        Editsound.setBackgroundResource(R.drawable.round_button);
                        EditVibrate.setBackgroundResource(R.drawable.round_button);
                        EditSilent.setBackgroundResource(R.drawable.round_selected_button);

                    } else {
                        isClickedbtn = true;
                        EditSilent.setBackgroundResource(R.drawable.round_button);
                        newSoundMode = null;
                    }
                }

            });


        daybtn1 = (Button) findViewById(R.id.ESunday);
        daybtn2 = (Button) findViewById(R.id.EMonday);
        daybtn3 = (Button) findViewById(R.id.ETuesday);
        daybtn4 = (Button) findViewById(R.id.EWednesday);
        daybtn5 = (Button) findViewById(R.id.EThursay);
        daybtn6 = (Button) findViewById(R.id.EFriday);
        daybtn7 = (Button) findViewById(R.id.ESaturday);

        sunday = fromOverviewData.getStringExtra("SUNDAY");
        monday = fromOverviewData.getStringExtra("MONDAY");
        tuesday = fromOverviewData.getStringExtra("TUESDAY");
        wednesday = fromOverviewData.getStringExtra("WEDNESDAY");
        thursday = fromOverviewData.getStringExtra("THURSDAY");
        friday = fromOverviewData.getStringExtra("FRIDAY");
        satueday = fromOverviewData.getStringExtra("SATURDAY");

        String SUN = "SUN "; String MON = "MON "; String TUE = "TUE "; String WED = "WED "; String THU = "THU ";
        String FRI = "FRI "; String SAT = "SAT ";

        if (SUN.equals(sunday)){
            daybtn1.setBackgroundResource(R.drawable.round_selected_button);
            newsunday = "SUN ";
        }
        if (MON.equals(monday)){
            daybtn2.setBackgroundResource(R.drawable.round_selected_button);
            newmonday = "MON ";
        }
        if (TUE.equals(tuesday)){
            daybtn3.setBackgroundResource(R.drawable.round_selected_button);
            newtuesday = "TUE ";
        }
        if (WED.equals(wednesday)){
            daybtn4.setBackgroundResource(R.drawable.round_selected_button);
            newwednesday = "WED ";
        }
        if (THU.equals(thursday)){
            daybtn5.setBackgroundResource(R.drawable.round_selected_button);
            newthursday = "THU ";
        }
        if (FRI.equals(friday)){
            daybtn6.setBackgroundResource(R.drawable.round_selected_button);
            newfriday = "FRI ";
        }
        if (SAT.equals(satueday)){
            daybtn7.setBackgroundResource(R.drawable.round_selected_button);
            newsaturday = "SAT ";
        }


        daybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sundayclick = "Y";
                if(sundayclick.equals(isbtnclickS)) {
                    v.setBackgroundResource(R.drawable.round_selected_button);
                    newsunday = "SUN ";
                    isbtnclickS = "N";
                }
                else {
                    v.setBackgroundResource(R.drawable.round_button);
                    newsunday = "";
                    isbtnclickS = "Y";
                }

            }
        });

        daybtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mondayClick = "Y";
                if(mondayClick.equals(isbtnclickM)) {
                    newmonday = "MON ";
                    v.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickM = "N";
                } else {
                    v.setBackgroundResource(R.drawable.round_button);
                    newmonday = "";
                    isbtnclickM = "Y";
                }
            }
        });

        daybtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tuesdayclick = "Y";
                if(tuesdayclick.equals(isbtnclickTU)) {
                    newtuesday = "TUE ";
                    daybtn3.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickTU = "N";
                } else {
                    daybtn3.setBackgroundResource(R.drawable.round_button);
                    newtuesday = "";
                    isbtnclickTU = "Y";
                }
            }
        });

        daybtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wednesdayclick = "Y";
                if(wednesdayclick.equals(isbtnclickW)) {
                    newwednesday = "WED ";
                    daybtn4.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickW = "N";
                } else {
                    newwednesday = "";
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
                    newthursday = "THU ";
                    daybtn5.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickTH = "N";
                } else {
                    newthursday= "";
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
                    newfriday = "FRI ";
                    daybtn6.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickF = "N";
                } else {
                    newfriday = "";
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
                    newsaturday = "SAT ";
                    daybtn7.setBackgroundResource(R.drawable.round_selected_button);
                    isbtnclickSA = "N";
                } else {
                    newsaturday ="";
                    daybtn7.setBackgroundResource(R.drawable.round_button);
                    isbtnclickSA = "Y";
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_btn, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save_btn) {

            String newDescriptionType = editText.getText().toString();
            String newDescription;
            if (newDescriptionType.isEmpty()){
                newDescription = "No Description";
            } else {
                newDescription = newDescriptionType;
            }
            myDB2.updateDescription(newDescription,ID,description);

            myDB2.updateSoundMode(newSoundMode,ID,selectedbtn);

            Integer newhour = timePicker.getCurrentHour();
            Integer newminute = timePicker.getCurrentMinute();
            myDB2.updateHour(newhour,ID,timeH);
            myDB2.updateMinute(newminute,ID,timeM);

            String Nsunday = newsunday; String Nmonday = newmonday; String Ntuesday = newtuesday; String Nwednesday = newwednesday;
            String Nthursday = newthursday; String Nfriday = newfriday; String Nsaturday = newsaturday;

            if (Nsunday.isEmpty() && Nmonday.isEmpty() && Ntuesday.isEmpty() && Nwednesday.isEmpty() && Nthursday.isEmpty() && Nfriday.isEmpty() && Nsaturday.isEmpty()){
                Toast.makeText(getApplicationContext(),"Day not selected",Toast.LENGTH_LONG).show();
            } else {
                myDB2.updateSunday(Nsunday, ID, sunday);
                myDB2.updateMonday(Nmonday, ID, monday);
                myDB2.updateTuesday(Ntuesday, ID, tuesday);
                myDB2.updateWednesday(Nwednesday, ID, wednesday);
                myDB2.updateThursday(Nthursday, ID, thursday);
                myDB2.updateFriday(Nfriday, ID, friday);
                myDB2.updateSaturday(Nsaturday, ID, satueday);
                Toast.makeText(getApplicationContext(), "Successfully Changed the Data", Toast.LENGTH_LONG).show();
                Intent loadoverviewactivity = new Intent(EditPlanActivity.this, OverviewActivity.class);
                startActivity(loadoverviewactivity);
            }

        }
        if (id == R.id.deletebtn){

            AlarmManager alarmManagers = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intent = new Intent(EditPlanActivity.this, AlarmReceiverActivity.class);
            PendingIntent alarmIntent  = PendingIntent.getBroadcast(getApplicationContext(),ID,intent,PendingIntent.FLAG_CANCEL_CURRENT);
            alarmManagers.cancel(alarmIntent);

            myDB2.deleteData(ID, description, selectedbtn);
            Intent loadoverviewactivity = new Intent(EditPlanActivity.this, OverviewActivity.class);
            startActivity(loadoverviewactivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}