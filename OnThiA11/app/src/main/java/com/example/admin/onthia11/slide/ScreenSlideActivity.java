package com.example.admin.onthia11.slide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.admin.onthia11.R;
import com.example.admin.onthia11.question.Question;
import com.example.admin.onthia11.question.QuestionController;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScreenSlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 20;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    TextView tvKiemTra, tvTimer, tvXemDiem;
    public int checkAns = 0;

    //CSDL
    QuestionController questionController;
    ArrayList<Question> arr_Ques;
    CounterClass timer;
    String subject;
    int number_exam;
    int totalTimer;
    String test = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        Intent intent = getIntent();
        subject = intent.getStringExtra("subject");
        number_exam = intent.getIntExtra("number_exam", 0);
        test = intent.getStringExtra("test");

        totalTimer = 15;
        timer = new CounterClass(totalTimer * 60 * 1000, 1000);
        questionController = new QuestionController(this);
        arr_Ques = new ArrayList<>();

        if (test.equals("yes") == true) {
            arr_Ques = questionController.getQuestion(number_exam, subject);
        } else {
            arr_Ques = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        }

        tvKiemTra = findViewById(R.id.tvKiemTra);
        tvTimer = findViewById(R.id.tvTimer);
        tvXemDiem = findViewById(R.id.tvScore);

        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
        tvXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent1 = new Intent(ScreenSlideActivity.this, TestDoneActivity.class);
                intent1.putExtra("arr_Ques", arr_Ques);
                startActivity(intent1);
            }
        });

        timer.start();
    }

    public ArrayList<Question> getData() {
        return arr_Ques;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            dialogExit();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void dialogExit() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ScreenSlideActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position, checkAns);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }


    //Dialog hiện thị danh sách những câu trả lời và chưa trả lời...
    public void checkAnswer() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Danh sách câu trả lời");

        CheckAnswerAdapter answerAdapter = new CheckAnswerAdapter(arr_Ques, this);
        GridView gvLsQuestion = dialog.findViewById(R.id.gvLsQuestion);
        gvLsQuestion.setAdapter(answerAdapter);

        gvLsQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });

        Button butCancle, butFinish;
        butCancle = dialog.findViewById(R.id.butCancle);
        butFinish = dialog.findViewById(R.id.butFinish);
        butCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        butFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////
                timer.cancel();
                result();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void result() {
        checkAns = 1;
        if (mPager.getCurrentItem() >= 4) mPager.setCurrentItem(mPager.getCurrentItem() - 4);
        else if (mPager.getCurrentItem() <= 4) mPager.setCurrentItem(mPager.getCurrentItem() + 4);
        tvXemDiem.setVisibility(View.VISIBLE);
        tvKiemTra.setVisibility(View.GONE);
    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime);
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");
            result();
        }
    }

}