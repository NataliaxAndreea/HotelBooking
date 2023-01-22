package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RoomInfoActivity extends AppCompatActivity {
    Calendar myCalendar;
    EditText edCheckin, edCheckout, editNumber;
    String name, email, address, phone, numberofperson;
    Spinner spinnerType;
    Button btnPreview;
    String roomType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        Intent i = getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        address = i.getStringExtra("address");
        numberofperson = i.getStringExtra("numberofperson");


        myCalendar = Calendar.getInstance();
        edCheckin = (EditText) findViewById(R.id.edCheckin);
        edCheckout = (EditText) findViewById(R.id.edCheckout);
        spinnerType = findViewById(R.id.SpinnerType);
        btnPreview = findViewById(R.id.btnPreview);
        editNumber = findViewById(R.id.editNumber);


        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoomInfoActivity.this, FinalActivity.class);
                i.putExtra("name", name);
                i.putExtra("email", email);
                i.putExtra("phone", phone);
                i.putExtra("address", address);
                i.putExtra("numberofperson", numberofperson);
                i.putExtra("roomType", roomType);
                i.putExtra("checkin", edCheckin.getText().toString());
                i.putExtra("checkout", edCheckout.getText().toString());
                i.putExtra("number", editNumber.getText().toString());
                startActivity(i);
            }
        });

        edCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(RoomInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        month = month + 1;
                        String date = dayofmonth + "/" + month + "/" + year;
                        edCheckin.setText(date);
                    }
                }, year, month, day);
                dialog.show();
            }
        });

        edCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(RoomInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        month = month + 1;
                        String date = dayofmonth + "/" + month + "/" + year;
                        edCheckout.setText(date);
                    }
                }, year, month, day);
                dialog.show();
            }
        });
    }
}

