package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {
    EditText editAddress, editName, editPhone, editEmail, editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        Button btnSave = findViewById(R.id.button);
        editAddress = findViewById(R.id.editAddress);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editNumber = findViewById(R.id.editNumber);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PersonalInfoActivity.this, RoomInfoActivity.class);
                i.putExtra("name", editName.getText().toString());
                i.putExtra("email", editAddress.getText().toString());
                i.putExtra("phone", editPhone.getText().toString());
                i.putExtra("address", editNumber.getText().toString());
                i.putExtra("numberofperson", editEmail.getText().toString());
                startActivity(i);
            }
        });
    }
    public void startdbapp(View View) {
        new DatabaseActivity(this);
        startActivity(new Intent(this, FinalActivity.class));
    }

}