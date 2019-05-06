package com.learning.educode.educode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class FinalTestScreen extends AppCompatActivity {

    public String lang,topic;
    private TextView mScoreView;
    private TextView number;
    private TextView mQuestionView;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;

    private  int mScore = 0, first, second, third;
    private  int mQuestionNumber,topicNumber ;
    private String mAnswer;

    private DatabaseReference mQuestionRef;
    private DatabaseReference mChoice1Ref;
    private DatabaseReference mChoice2Ref;
    private DatabaseReference mChoice3Ref;
    private DatabaseReference mChoice4Ref;
    private DatabaseReference mAnswerRef;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_test_screen);

        number = (TextView)findViewById(R.id.number);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        Intent intent = getIntent();
        lang = intent.getStringExtra("lang");
        topic = intent.getStringExtra("topic");

        if(!isConnected(FinalTestScreen.this)) {
            buildDialog(FinalTestScreen.this).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Please wait, Test is loading !!",Toast.LENGTH_SHORT).show();
            updateQuestion();
        }

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice4.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
    }

    //Network checking starts
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())){
                return true;
            }
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to Start Mobile Data or wifi to access Test. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        return builder;
    }
    //till this Network checking

    private void updateScore(int score){
        mScoreView.setText(""+mScore);
    }
    private void updateQuestion(){
        if (mQuestionNumber<=24){
            number.setText((mQuestionNumber+1)+"/25");
        }
        else {
            Intent i = new Intent(FinalTestScreen.this, FinalResultScreen.class);
            i.putExtra("score", mScore);
            i.putExtra("lang",lang );
            i.putExtra("topic",topic );
            startActivity(i);
            finish();
        }

        Random r = new Random();
        int questionNumber = r.nextInt(50);
//        if (mQuestionNumber == 1)
//        {
//            first = questionNumber;
//        }
//        if (mQuestionNumber == 2)
//        {
//            second = questionNumber;
//        }
//        if (mQuestionNumber == 3)
//        {
//            third = questionNumber;
//        }
//        if (first == questionNumber){
//            if (questionNumber < 5)
//            {
//                questionNumber = questionNumber+1;
//            }
//            else{
//                questionNumber = questionNumber-1;
//            }
//            if (first == third){
//                if (questionNumber < 5)
//                {
//                    questionNumber = questionNumber+1;
//                }
//                else{
//                    questionNumber = questionNumber-1;
//                }
//            }
//            if (first == second){
//                if (questionNumber < 5)
//                {
//                    questionNumber = questionNumber+1;
//                }
//                else{
//                    questionNumber = questionNumber-1;
//                }
//            }
//        }
        if (questionNumber >= 50)
        {
            questionNumber = questionNumber-10;
        }

        mQuestionRef = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestionView.setText(question);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mChoice1Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/choice1");
        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mChoice2Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/choice2");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mChoice3Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/choice3");
        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mChoice4Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/choice4");
        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mAnswerRef = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/Final"+lang+"/"+questionNumber+"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mQuestionNumber++;
        try { Thread.sleep(500); }
        catch (InterruptedException ex) { android.util.Log.d("EduCode", ex.toString()); }
    }
}
