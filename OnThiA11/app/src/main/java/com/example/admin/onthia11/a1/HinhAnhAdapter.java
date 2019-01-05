package com.example.admin.onthia11.a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.admin.onthia11.R;

import java.util.ArrayList;

public class HinhAnhAdapter extends ArrayAdapter<HinhAnh> {

    public HinhAnhAdapter(Context context, ArrayList<HinhAnh> hinhAnh) {
        super(context, 0, hinhAnh);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView= inflater.inflate(R.layout.item_gridview_bien_bao, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imgviewBienBao);

        HinhAnh p = getItem(position);
        if(p!=null){
            imageView.setImageResource(p.getHinh());
        }
        return convertView;
    }
}
