package com.example.dell.rolodex;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Edit_noteActivity extends AppCompatActivity {

    Database_Activity myDB;
    private static final String TAG = "Edit_noteActivity";
    EditText edittxtdescription;

    private String SelectedDescription;
    private int SelectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        edittxtdescription = (EditText) findViewById(R.id.Editdescriptiontxt);
        Button editsavebtn = (Button) findViewById(R.id.EditsaveNotes);
        Button editdeletebtn = (Button) findViewById(R.id.EditDeleteNotes);
        myDB = new Database_Activity(this);

        Intent fromSpecialNoteActivityData = getIntent();
        SelectedID = fromSpecialNoteActivityData.getIntExtra("id",-1);
        SelectedDescription = fromSpecialNoteActivityData.getStringExtra("Description");

        edittxtdescription.setText(SelectedDescription);

       editsavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = edittxtdescription.getText().toString();
               // if (item.equals("")) {
                    myDB.updateDescription(item, SelectedID, SelectedDescription);
               // }
                Intent loadoverviewactivity = new Intent(Edit_noteActivity.this, SpecialNoteActivity.class);
                startActivity(loadoverviewactivity);
            }
        });

       editdeletebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               myDB.deleteDescription(SelectedID,SelectedDescription);
               edittxtdescription.setText("");

               Intent loadoverviewactivity = new Intent(Edit_noteActivity.this, SpecialNoteActivity.class);
               startActivity(loadoverviewactivity);
           }
       });
    }

    public void editinputspeech(View view) {

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
                    edittxtdescription.setText(result.get(0));
                }
                break;
        }

    }


}
