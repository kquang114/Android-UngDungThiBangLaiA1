package com.example.admin.onthia11.score;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.onthia11.R;


public class ScoreAdapter extends CursorAdapter{
    public ScoreAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_score, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvScore= view.findViewById(R.id.tvScore);
        TextView tvName= view.findViewById(R.id.tvNameStudent);
        TextView tvNghe= view.findViewById(R.id.tvNghe);
        EditText editDate= view.findViewById(R.id.editDate);

        tvName.setText(cursor.getString(1));
        tvNghe.setText(cursor.getString(4));
        editDate.setText(cursor.getString(3));
        tvScore.setText(cursor.getInt(2)+"");
    }
}

