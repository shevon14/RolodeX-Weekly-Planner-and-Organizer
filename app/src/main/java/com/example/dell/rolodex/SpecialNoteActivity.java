package com.example.dell.rolodex;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class SpecialNoteActivity extends AppCompatActivity {


    Database_Activity myDB;
    ArrayList<Notes>arrayList;
    ListView listPlans;
    CustomSPListAdapter notesadapter;

    int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_note);


        listPlans = (ListView) findViewById(R.id.SNdescriptionList);
        myDB = new Database_Activity(this);
        arrayList = new ArrayList<>();
        loadData();

        FloatingActionButton addnotebtn = (FloatingActionButton) findViewById(R.id.fabnote);

        addnotebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadoverviewactivity = new Intent(SpecialNoteActivity.this, Add_note_Activity.class);
                startActivity(loadoverviewactivity);
            }
        });

        listPlans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Id = position;
                Intent loadEditnoteActivity = new Intent(SpecialNoteActivity.this,Edit_noteActivity.class);
                loadEditnoteActivity.putExtra("id",arrayList.get(position).id);
                loadEditnoteActivity.putExtra("Description",arrayList.get(position).Notedescription);
                startActivity(loadEditnoteActivity);

            }
        });

        TextView emptytext = (TextView)findViewById(R.id.nonotesavaliable);
        listPlans.setEmptyView(emptytext);

    }

    private void loadData(){
        arrayList = myDB.getAllData();
        notesadapter = new CustomSPListAdapter(this,arrayList);
        listPlans.setAdapter(notesadapter);
        notesadapter.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        Intent loadHomeActivity = new Intent(SpecialNoteActivity.this,MainActivity.class);
        startActivity(loadHomeActivity);
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_bttn,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.addplan){
            Intent loadoverviewactivity = new Intent(SpecialNoteActivity.this, Add_note_Activity.class);
            startActivity(loadoverviewactivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }  */


}
