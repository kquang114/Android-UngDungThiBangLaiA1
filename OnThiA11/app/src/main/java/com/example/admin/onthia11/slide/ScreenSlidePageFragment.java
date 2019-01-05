package com.example.admin.onthia11.slide;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.admin.onthia11.R;
import com.example.admin.onthia11.question.Question;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {


    ArrayList<Question> arr_Ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    private int mPageNumber;
    public int checkAns;

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton rad1, rad2, rad3;
    ImageView imgIcon;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        rad1 = rootView.findViewById(R.id.rad1);
        rad2 = rootView.findViewById(R.id.rad2);
        rad3 = rootView.findViewById(R.id.rad3);
        imgIcon = rootView.findViewById(R.id.ivIcon);
        radioGroup = rootView.findViewById(R.id.radGroup);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);
    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER, checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("CÂU SỐ " + (mPageNumber + 1));
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
        rad1.setText(getItem(mPageNumber).getAnswer_1());
        rad2.setText(getItem(mPageNumber).getAnswer_2());
        rad3.setText(getItem(mPageNumber).getAnswer_3());

        imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage()+"","drawable","com.example.admin.onthia11"));

        if(checkAns!=0){
            rad1.setClickable(false);
            rad2.setClickable(false);
            rad3.setClickable(false);
            getCheckAns(getItem(mPageNumber).getResult().toString());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(mPageNumber).choiceID = checkedId;
                getItem(mPageNumber).setTraloi(getChoiceFromID(checkedId));
            }
        });
    }

    public Question getItem(int posotion) {
        return arr_Ques.get(posotion);
    }

    private String getChoiceFromID(int ID) {
        if (ID == R.id.rad1) {
            return "1";
        } else if (ID == R.id.rad2) {
            return "2";
        } else if (ID == R.id.rad3) {
            return "3";
        } else return "";
    }

    private void getCheckAns(String ans) {
        if (ans.equals("1") == true) {
            rad1.setBackgroundColor(Color.BLUE);
        } else if (ans.equals("2") == true) {
            rad2.setBackgroundColor(Color.BLUE);
        } else if (ans.equals("3") == true) {
            rad3.setBackgroundColor(Color.BLUE);
        } else ;
    }
}
