package com.example.admin.onthia11.a1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.admin.onthia11.MainActivity;
import com.example.admin.onthia11.R;
import com.example.admin.onthia11.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoDeThiFragment extends Fragment {


    ExamAdapter examAdapter;
    GridView gvExam;
    ArrayList<Exam> arr_exam = new ArrayList<>();

    public BoDeThiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Bộ Đề Thi");
        return inflater.inflate(R.layout.fragment_bo_de_thi, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvExam = getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Đề Số 1"));
        arr_exam.add(new Exam("Đề Số 2"));
        arr_exam.add(new Exam("Đề Số 3"));
        arr_exam.add(new Exam("Đề Số 4"));
        arr_exam.add(new Exam("Đề Số 5"));
        arr_exam.add(new Exam("Đề Số 6"));
        arr_exam.add(new Exam("Đề Số 7"));
        arr_exam.add(new Exam("Đề Số 8"));

        examAdapter = new ExamAdapter(getActivity(), arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("number_exam", i + 1);
                intent.putExtra("subject", "thithu");
                intent.putExtra("test", "yes");
                startActivity(intent);
            }
        });
    }
}
