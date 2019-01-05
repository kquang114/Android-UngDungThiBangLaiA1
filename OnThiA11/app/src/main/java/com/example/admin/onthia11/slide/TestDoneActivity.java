package com.example.admin.onthia11.slide;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.onthia11.R;
import com.example.admin.onthia11.question.Question;
import com.example.admin.onthia11.score.ScoreController;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin= new ArrayList<>();
    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;
    int totalScore=0;

    ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalPoint;
    Button butSave, butAgain, butThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
        scoreController=new ScoreController(TestDoneActivity.this);

        final Intent intent= getIntent();
        arr_QuesBegin= (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        checkResult();
        totalScore= numTrue*10;
        tvNotAns.setText(""+numNoAns);
        tvFalse.setText(""+numFalse);
        tvTrue.setText(""+numTrue);
        tvTotalPoint.setText(""+totalScore);

        butThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
        });

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater=TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.allert_dialog_save_score,null);
                builder.setView(view);

                final EditText edtName= view.findViewById(R.id.edtName);
                final EditText edtNghe= view.findViewById(R.id.edtNghe);
                TextView tvScore= view.findViewById(R.id.tvScore);
                final int numTotal= numTrue*10;
                tvScore.setText(numTotal+" điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name= edtName.getText().toString();
                        String nghe= edtNghe.getText().toString();
                        scoreController.insertScore(name,numTotal,nghe);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công!",Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog b= builder.create();
                b.show();
            }
        });

        butAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                finish();
                Intent intent2= new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent2.putExtra("arr_Ques",arr_QuesBegin);
                intent2.putExtra("test","no");
                startActivity(intent2);
            }
        });

    }

    public void refresh(){
        for(int i=0; i<arr_QuesBegin.size(); i++){
            arr_QuesBegin.get(i).setTraloi("");
        }
    }

    public void begin(){
        tvFalse= findViewById(R.id.tvFalse);
        tvTrue= findViewById(R.id.tvTrue);
        tvNotAns= findViewById(R.id.tvNotAns);
        tvTotalPoint= findViewById(R.id.tvTotalPoint);
        butAgain= findViewById(R.id.butAgain);
        butSave= findViewById(R.id.butSave);
        butThoat= findViewById(R.id.butThoat);
    }

    //PT Check kết quả
    public void checkResult(){
        for(int i=0; i< arr_QuesBegin.size(); i++){
            if(arr_QuesBegin.get(i).getTraloi().equals("")==true){
                numNoAns++;
            }else if(arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi())==true){
                numTrue++;
            }else numFalse++;
        }
    }

}
