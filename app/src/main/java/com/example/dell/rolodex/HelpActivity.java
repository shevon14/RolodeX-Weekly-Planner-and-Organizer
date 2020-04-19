package com.example.dell.rolodex;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ImageButton urlbtn1 = (ImageButton) findViewById(R.id.URLbtn1);
        //ImageButton urlbtn2 = (ImageButton) findViewById(R.id.URLbtn2);

        urlbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(googleintent);
            }
        });

    }
}
