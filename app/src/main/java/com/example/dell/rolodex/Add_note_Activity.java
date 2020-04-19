package com.example.dell.rolodex;

import android.content.Intent;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Add_note_Activity extends AppCompatActivity {

    Database_Activity myDB;
    EditText editTextDescription;
    ImageButton addtextmic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_);


        editTextDescription = (EditText) findViewById(R.id.descriptiontxt);

        addtextmic = (ImageButton) findViewById(R.id.addnotemic);

        Button savebtn = (Button) findViewById(R.id.saveNotes);
        myDB = new Database_Activity(this);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // String newEntry = editTextDescription.getText().toString();
                if (editTextDescription.length()!=0){
                    String notedescription = editTextDescription.getText().toString();
                    myDB.addData(notedescription);
                    editTextDescription.setText("");
                    Toast.makeText(getApplicationContext(),"Note has been recored.",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Add_note_Activity.this,"Note not recorded",Toast.LENGTH_LONG).show();
                }

                Intent loadoverviewactivity = new Intent(Add_note_Activity.this, SpecialNoteActivity.class);
                startActivity(loadoverviewactivity);

            }
        });

    }


    public void getinputspeech(View view) {

        Intent inputspeechintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        inputspeechintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        inputspeechintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (inputspeechintent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(inputspeechintent,100);
        } else {
            Toast.makeText(getApplicationContext(),"Your mobile doesn't support this function",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 100:
                if (resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editTextDescription.setText(result.get(0));
                }
                break;
        }

    }


    /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.save_button,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.savebttn){
            Intent loadoverviewactivity = new Intent(Add_note_Activity.this, SpecialNoteActivity.class);
            startActivity(loadoverviewactivity);
            return true;

        }

        return super.onOptionsItemSelected(item);
    } */


}
