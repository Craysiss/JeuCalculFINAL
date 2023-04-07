package com.example.jeucalculfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SCORES";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SCORE";
    private static final String KEY_ID = "id";
    private static final String SCORE = "score";
    private static final String PSEUDO = "pseudo";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SCORE + " TEXT, " + PSEUDO + " TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addScore(String score, String pseudo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SCORE, score);
        values.put(PSEUDO, pseudo);
        db.insert(TABLE_NAME, null,values);
    }

    public ArrayList<ModalScore> fetchScore(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY CAST(" + SCORE + " AS INTEGER) DESC LIMIT 5", null);

        ArrayList<ModalScore> arrayList = new ArrayList<>();

        while(cursor.moveToNext()){
            ModalScore modalScore = new ModalScore();
            modalScore.id = cursor.getInt(0);
            modalScore.score = cursor.getString(1);
            modalScore.pseudo = cursor.getString(2);

            arrayList.add(modalScore);
        }
        return arrayList;
    }
}











