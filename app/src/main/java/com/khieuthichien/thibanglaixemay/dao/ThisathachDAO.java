package com.khieuthichien.thibanglaixemay.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.khieuthichien.thibanglaixemay.database.DatabaseHelper;
import com.khieuthichien.thibanglaixemay.model.QuestionTSH;

import java.util.ArrayList;

public class ThisathachDAO {

    public DatabaseHelper dbHelper;

    public ThisathachDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<QuestionTSH> getQuestion(int num_exam, String subject) {
        ArrayList<QuestionTSH> lsData = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DeBLX  WHERE num_exam = '" + num_exam + "' AND subject='" + subject + "'", null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            QuestionTSH item;
            item = new QuestionTSH(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7), cursor.getString(8), cursor.getString(9));
            lsData.add(item);
        }
        return lsData;
    }

}
