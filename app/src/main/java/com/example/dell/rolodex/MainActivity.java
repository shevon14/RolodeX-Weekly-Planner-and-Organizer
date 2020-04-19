package com.example.dell.rolodex;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    String[] listitems = {
            "Plans", "Notes", "Calendar", "Help", "About"};
    Integer[] listimg = {
            R.drawable.daily_overview, R.drawable.special_notes, R.drawable.calendar, R.drawable.help, R.drawable.about};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(MainActivity.this,"Welcome!",Toast.LENGTH_LONG).show();

        CustomListAdapter adapter = new CustomListAdapter(this, listitems, listimg);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent OverviewActivity = new Intent(MainActivity.this, OverviewActivity.class);
                    startActivity(OverviewActivity);

                } else if (position == 1) {
                    Intent SpecilNotesActivity = new Intent(MainActivity.this, SpecialNoteActivity.class);
                    startActivity(SpecilNotesActivity);
                } else if (position == 2) {
                    Intent CalendarviewActivity = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(CalendarviewActivity);
                } else if (position == 3) {
                    Intent HelpActivity = new Intent(MainActivity.this, HelpActivity.class);
                    startActivity(HelpActivity);

                } else {
                    Intent AboutActivity = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(AboutActivity);

                }

            }
        });

    }


   @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_tittle);

        builder.setPositiveButton(R.string.dialog_bt1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishAffinity();
            }
        });
        builder.setNegativeButton(R.string.dialog_bt2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }





}


