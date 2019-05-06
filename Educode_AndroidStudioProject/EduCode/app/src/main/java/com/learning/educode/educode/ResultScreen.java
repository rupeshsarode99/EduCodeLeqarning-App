package com.learning.educode.educode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    TextView result, score2;
    TextView showLang, showTopic;
    public String extra, topic;

    int percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        showLang = (TextView) findViewById(R.id.showLang);
        showTopic = (TextView) findViewById(R.id.showTopic);
        result = (TextView)findViewById(R.id.result);
        score2 = (TextView)findViewById(R.id.score2);

        Intent i = getIntent();
        int score = i.getIntExtra("score", 0);
        extra = i.getStringExtra("lang");
        topic = i.getStringExtra("topic");
//        showTopic.setText(topic);
//        showLang.setText(extra);

        if(score==0){
            result.setText("Failed! Better luck next time. \nYour Score is : "+score+"/5.");
        }
        else if(score>0 && score<=2){
            result.setText("Well Done! \nYour Score is : "+score+"/5.");
        }
        else if(score>2){
            result.setText("Excellent! \nYour Score is : "+score+"/5.");
        }


        SharedPreferences preferences = ResultScreen.this.getSharedPreferences("Mydata", MODE_PRIVATE);
//        score1.setText(preferences.getString(extra+topic, String.valueOf(0)));
        percent = score *2;
        int total=10;
        percent = ((percent*10)/total);
//        strscore = String.valueOf(percent);

        //score2.setText(String.valueOf(percent));

        SharedPreferences.Editor editor;
        editor = preferences.edit();
//        editor.putString("PythonIntro", String.valueOf(percent));
//        editor.putString("PythonIntro", String.valueOf(percent));
        editor.putInt(extra+topic, percent);
        editor.commit();

//        score2.setText(preferences.getString(extra+topic, "Not Found"));
    }
}
