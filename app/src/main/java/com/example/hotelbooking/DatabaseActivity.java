package com.example.hotelbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseActivity extends SQLiteOpenHelper {
    //Database version
    private static final int Database_version =1;
    //Database name
    private static final String Database_name="HB.db";
    //Table name
    private static final String Table_name="userdata";
    //Table fields
    private static final String Column_name="name";
    private static final String Column_email="email";
    private static final String Column_phone="phone";
    private static final String Column_address="address";
    private static final String Column_numberofperson="numberofperson";
    private static final String Column_roomType="roomType";
    private static final String Column_checkin="checkin";
    private static final String Column_checkout="checkout";
    private static final String Column_numberofrooms="numberofrooms";

    SQLiteDatabase database;

    public DatabaseActivity( Context context) {
        super(context, Database_name, null, Database_version);
        database=getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String qry=("CREATE TABLE "+Table_name+" (id INTEGER PRIMARY KEY autoincrement, name text, email text, phone number,address text,numberofperson number, roomType text, checkin date, checkout date, numberofrooms number)");
        database.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    database.execSQL("DROP TABLE IF EXISTS userdata");
    onCreate(database);
    }

    public String addRecord(String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p8, String p9) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",p1);
        cv.put("name",p2);
        cv.put("name",p3);
        cv.put("name",p4);
        cv.put("name",p5);
        cv.put("name",p6);
        cv.put("name",p7);
        cv.put("name",p8);
        cv.put("name",p9);

        long res=db.insert("userdata", null, cv);

        if(res==-1)
            return  "Failed";
        else
            return "Successfully inserted";
    }
}
