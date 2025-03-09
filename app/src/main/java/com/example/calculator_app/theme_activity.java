package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class theme_activity extends AppCompatActivity {

    public static boolean dark_theme_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        getSupportActionBar().setTitle("Theme");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}