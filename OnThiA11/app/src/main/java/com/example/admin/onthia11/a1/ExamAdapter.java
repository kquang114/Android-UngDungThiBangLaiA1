package com.example.admin.onthia11.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.onthia11.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_gridview, parent, false);
        }
        TextView tvName= convertView.findViewById(R.id.tvNumberExam);
        ImageView imgIcon= convertView.findViewById(R.id.imgIcon);

        Exam p= getItem(position);
        if(p!=null){
            tvName.setText(""+ p.getName());
            imgIcon.setImageResource(R.drawable.book);
        }

        return convertView;
    }
}
