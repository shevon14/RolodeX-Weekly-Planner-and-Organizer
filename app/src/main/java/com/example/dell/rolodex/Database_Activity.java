package com.example.dell.rolodex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Database_Activity extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="MyDatabase.db";
    public static final String TABLE_NAME = "SpecialNote_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "Description";

    public Database_Activity(Context context){super(context,DATABASE_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "Description TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String Description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,Description);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }

    }
/*
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;
    }
*/
    public ArrayList<Notes> getAllData(){
        ArrayList<Notes> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        while (data.moveToNext()){
            int id = data.getInt(0);
            String description = data.getString(1);
            Notes notes = new Notes(id,description);
            arrayList.add(notes);
        }
        return arrayList;
    }

   /* public Cursor getItemID(String description){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME + " WHERE " + COL2 + " = '" + description + "'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }*/


    public void updateDescription(String newDescription,int id,String oldDescription){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '" + newDescription + "' WHERE " + COL1 + " = '" + id + "'" + " AND " + COL2 + " = '" + oldDescription + "'";
        //Log.d(TAG, "UpdateDescription: querry: " + querry);
        //Log.d(TAG, "UpdateDescription: Setting name to " + newDescription);
        db.execSQL(querry);
    }

    public void deleteDescription(int id, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'" + " AND " + COL2 + " = '" + description + "'";
        db.execSQL(querry);
    }




}


