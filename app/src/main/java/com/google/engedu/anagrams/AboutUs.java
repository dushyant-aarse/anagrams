package com.google.engedu.anagrams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    TextView title, desc, creators, guidance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        title = (TextView) findViewById(R.id.title);
        desc = (TextView) findViewById(R.id.desc);
        creators = (TextView) findViewById(R.id.creators);
        guidance = (TextView) findViewById(R.id.guidance);
    }
}
