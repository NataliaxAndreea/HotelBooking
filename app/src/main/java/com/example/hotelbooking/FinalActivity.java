package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {
    String name, email, address, phone, numberofperson;
    String roomType,CheckinDate,CheckoutDate,numberofrooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView textView=findViewById(R.id.textView1);

       // DatabaseActivity databaseActivity= new DatabaseActivity(this);

        Intent i=getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        address = i.getStringExtra("address");
        numberofperson = i.getStringExtra("numberofperson");
        roomType = i.getStringExtra("roomType");
        CheckinDate = i.getStringExtra("checkin");
        CheckoutDate = i.getStringExtra("checkout");
        numberofrooms = i.getStringExtra("number");



        textView.setText(
                        "Name"+name+
                        "\nEmail"+email+
                                "\nPhone"+phone+
                        "\nAddress"+address+
                        "\nNumberofperson"+numberofperson+
                        "\nRoomType"+roomType+
                        "\nCheckinDate"+CheckinDate+
                        "\nCheckoutDate"+CheckoutDate+
                        "\nNumberofrooms"+numberofrooms
        );

        }
        public void addRecord(View view){
        DatabaseActivity db=new DatabaseActivity(this);
        String res=db.addRecord(name ,email,phone, address, numberofperson,roomType, CheckinDate,CheckoutDate,numberofrooms);

        }
    }
