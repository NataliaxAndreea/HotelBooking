package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBookNow;
    Button btnBookNow2;
    Button btnBookNow3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBookNow = findViewById(R.id.btnBookNow);
        btnBookNow2 = findViewById(R.id.btnBookNow2);
        btnBookNow3 = findViewById(R.id.btnBookNow3);
        btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, PersonalInfoActivity.class);
                int1.putExtra("info", "Standard Room");
                startActivity(int1);
            }
        });
        btnBookNow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainActivity.this, PersonalInfoActivity.class);
                int2.putExtra("info", "Double Room");
                startActivity(int2);
            }
        });
        btnBookNow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(MainActivity.this, PersonalInfoActivity.class);
                int3.putExtra("info", "Apartment");
                startActivity(int3);
            }
        });
    }
}