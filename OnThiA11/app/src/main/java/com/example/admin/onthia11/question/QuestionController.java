package com.example.admin.onthia11.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper= new DBHelper(context);
    }

    public ArrayList<Question> getQuestion(int number_exam, String subject){
        ArrayList<Question> lsData= new ArrayList<>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from bodea1 where number_exam = '"+number_exam+"' and subject='"+subject+"' order by random()",null);
        cursor.moveToFirst();
        do {
            Question item;
            item = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7), cursor.getString(8),"");
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }

    public Cursor getSearchQuestion(String number_exam,String key) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from bodea1 where question like '%"+key+"%' and subject like '%"+number_exam+"%'",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getQuestionByNumber_Exam(String key) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from bodea1 where number_exam like '%"+key+"%'",null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
