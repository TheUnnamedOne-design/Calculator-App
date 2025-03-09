package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class introduction extends AppCompatActivity {

    Button button,theme_button,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        button=(Button)findViewById(R.id.calculator_access_button);
        theme_button=(Button)findViewById(R.id.Theme_button);
        exit=(Button)findViewById(R.id.Exit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(introduction.this,calculator_theme_dark.class);
                startActivity(intent);
            }
        });

        theme_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(introduction.this,theme_activity.class);
                startActivity(intent);
            }
        });
    }
}