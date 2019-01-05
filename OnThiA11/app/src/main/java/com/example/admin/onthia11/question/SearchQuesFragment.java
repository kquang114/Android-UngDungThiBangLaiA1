package com.example.admin.onthia11.question;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.admin.onthia11.MainActivity;
import com.example.admin.onthia11.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchQuesFragment extends Fragment {

    ListView lvQuestion;
    QuestionController questionController;
    QuestionAdapter adapter;
    EditText edtSearch;
    ImageButton imgSubject;
    String number_exam="";

    public SearchQuesFragment() {
        // Required empty public constructor
    }

    public void begin() {
        lvQuestion = getActivity().findViewById(R.id.lvQuestion);
        edtSearch = getActivity().findViewById(R.id.edtSearch);
        imgSubject= getActivity().findViewById(R.id.imgSubject);
        questionController = new QuestionController(getActivity());
        listCursor(questionController.getSearchQuestion(number_exam,edtSearch.getText().toString()));
    }

    public void listCursor(Cursor cursor) {
        adapter = new QuestionAdapter(getActivity(), cursor, true);
        lvQuestion.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("");
        return inflater.inflate(R.layout.fragment_search_ques, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        begin();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listCursor(questionController.getSearchQuestion(number_exam,edtSearch.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

    }

    public void showMenu(View v){
        PopupMenu popupMenu= new PopupMenu(getActivity(), v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.questall:
                        number_exam="";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso1:
                        number_exam="1";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso2:
                        number_exam="2";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso3:
                        number_exam="3";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso4:
                        number_exam="4";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso5:
                        number_exam="5";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso6:
                        number_exam="6";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso7:
                        number_exam="7";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                    case R.id.deso8:
                        number_exam="8";
                        listCursor(questionController.getQuestionByNumber_Exam(number_exam));
                        break;
                }
                return false;
            }
        });
        popupMenu.inflate(R.menu.menu_question);
        setForceShowIcon(popupMenu);
        popupMenu.show();
    }


    //Hiện thị icon trên popupMenu Field
    //import java.lang.reflect.Field;
    //import java.lang.reflect.Method;
    public static void setForceShowIcon(PopupMenu popupMenu) {
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
