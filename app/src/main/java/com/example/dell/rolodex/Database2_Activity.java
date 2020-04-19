package com.example.dell.rolodex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class Database2_Activity extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="MyDatabase2.db2";
    public static final String TABLE_NAME = "DailyPlans_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "Description";
    public static final String COL3 = "Hour";
    public static final String COL4 = "Minute";
    public static final String COL5 = "SoundMode";
    public static final String COL6 = "Sunday";
    public static final String COL7 = "Monday";
    public static final String COL8 = "Tuesday";
    public static final String COL9 = "Wednesday";
    public static final String COL10 = "Thursday";
    public static final String COL11 = "Friday";
    public static final String COL12 = "Saturday";
    public static final String COL13 = "Notifications";

    public Database2_Activity (Context context){super(context,DATABASE_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "Description TEXT,Hour INTEGER, Minute INEGER, SoundMode TEXT, Sunday TEXT, Monday Text, Tuesday TEXT, Wednesday TEXT, Thursday TEXT, Friday TEXT, Saturday TEXT, Notifications TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String Description,Integer Hour, Integer Minute, String SoundMode, String Sunday ,String Monday, String Tuesday, String Wednesday, String Thursday, String Friday, String Saturday, String Notifications){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,Description);
        contentValues.put(COL3,Hour);
        contentValues.put(COL4,Minute);
        contentValues.put(COL5,SoundMode);
        contentValues.put(COL6,Sunday);
        contentValues.put(COL7,Monday);
        contentValues.put(COL8,Tuesday);
        contentValues.put(COL9,Wednesday);
        contentValues.put(COL10,Thursday);
        contentValues.put(COL11,Friday);
        contentValues.put(COL12,Saturday);
        contentValues.put(COL13,Notifications);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<Plans> getAllData(){
        ArrayList<Plans> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        while (data.moveToNext()){
            int id = data.getInt(0);
            String description = data.getString(1);
            Integer hour = data.getInt(2);
            Integer minute = data.getInt(3);
            String soundmode = data.getString(4);
            String sunday = data.getString(5);
            String monday = data.getString(6);
            String tuesday = data.getString(7);
            String wednesday = data.getString(8);
            String thursday = data.getString(9);
            String friday = data.getString(10);
            String saturday = data.getString(11);
            String notifications = data.getString(12);

            Plans plans = new Plans(id,description,hour,minute,soundmode,sunday,monday,tuesday,wednesday,thursday,friday,saturday,notifications);
            arrayList.add(plans);
        }
        return arrayList;
    }
/*
    public Cursor getDataID(int id, String description, String time, String soundmode, String days){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'" + " AND " + COL2 + " = '" + description + "' AND " + COL3 + " = '" + time + "' AND " + COL4 + " = '" + soundmode + "' AND " + COL5 + "= '" + days + "'" ;
        Cursor data = db.rawQuery(query,null);
        return data;
    }*/


    public void updateHour(Integer newHour, int id,Integer oldHour){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL3 + " = '" + newHour + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL3 + " = '" + oldHour + "'";

        db.execSQL(querry);
    }

    public void updateMinute(Integer newMinute, int id,Integer oldMinute){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL4 + " = '" + newMinute + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL4 + " = '" + oldMinute + "'";

        db.execSQL(querry);
    }


    public void updateSoundMode(String newSoundmode, int id,String oldSoundmode){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL5 + " = '" + newSoundmode + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL5 + " = '" + oldSoundmode + "'";
        db.execSQL(querry);
    }

    public void updateSunday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL6 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL6 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateMonday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL7 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL7 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateTuesday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL8 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL8 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateWednesday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL9 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL9 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateThursday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL10 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL10 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateFriday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL11 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL11 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }
    public void updateSaturday(String newDay, int id,String oldDay){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL12 + " = '" + newDay+ "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL12 + " = '" + oldDay + "'";
        db.execSQL(querry);
    }

    public void updateDescription(String newDescription, int id,String oldDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '" + newDescription + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL2 + " = '" + oldDescription + "'";
        //Log.d(TAG, "UpdateDescription: querry: " + querry);
        //Log.d(TAG, "UpdateDescription: Setting name to " + newDescription);
        db.execSQL(querry);
    }

    public void updateNotifcation(String newNotification, int id,String oldNotification){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL13 + " = '" + newNotification + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL13 + " = '" + oldNotification + "'";
        //Log.d(TAG, "UpdateDescription: querry: " + querry);
        //Log.d(TAG, "UpdateDescription: Setting name to " + newDescription);
        db.execSQL(querry);
    }

    public void deleteData(int id, String description, String soundmode){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'" ;
                //" AND " + COL2 + " = '" + description + "' AND " + COL3 + " = '" + time + "' AND " + COL4 + " = '" + soundmode + "' ";
        db.execSQL(querry);
    }

//String sunday, String monday, String tuesday,
// String wednesday, String thursday, String friday, String saturday


}

