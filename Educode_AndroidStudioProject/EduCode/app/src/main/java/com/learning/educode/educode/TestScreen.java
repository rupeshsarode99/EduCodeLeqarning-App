package com.learning.educode.educode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
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
import java.util.Timer;

public class TestScreen extends AppCompatActivity {

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
        setContentView(R.layout.activity_test_screen);

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

        if (lang.equals("Python"))
        {
            if (topic.equals("Intro")){
                topicNumber = 0;
            }
            else if (topic.equals("Operators")){
                topicNumber = 1;
            }
            else if (topic.equals("Variables")){
                topicNumber = 2;
            }
            else if (topic.equals("Decision")){
                topicNumber = 3;
            }
            else if (topic.equals("Loops")){
                topicNumber = 4;
            }
            else if (topic.equals("Date")){
                topicNumber = 5;
            }
            else if (topic.equals("List")){
                topicNumber = 6;
            }
            else if (topic.equals("GUI")){
                topicNumber = 7;
            }
            else if (topic.equals("Function")){
                topicNumber = 8;
            }
            else if (topic.equals("Database")){
                topicNumber = 9;
            }
        }
        else if (lang.equals("PHP"))
        {
            if (topic.equals("Intro")){
                topicNumber = 0;
            }
            else if (topic.equals("Syntax")){
                topicNumber = 1;
            }
            else if (topic.equals("Variables")){
                topicNumber = 2;
            }
            else if (topic.equals("Datatypes")){
                topicNumber = 3;
            }
            else if (topic.equals("String")){
                topicNumber = 4;
            }
            else if (topic.equals("Operators")){
                topicNumber = 5;
            }
            else if (topic.equals("If")){
                topicNumber = 6;
            }
            else if (topic.equals("Switch")){
                topicNumber = 7;
            }
            else if (topic.equals("While")){
                topicNumber = 8;
            }
            else if (topic.equals("For")){
                topicNumber = 9;
            }
        }
        else if (lang.equals("Java"))
        {
            if (topic.equals("Intro")){
                topicNumber = 0;
            }
            else if (topic.equals("Basic")){
                topicNumber = 1;
            }
            else if (topic.equals("Variable")){
                topicNumber = 2;
            }
            else if (topic.equals("Operator")){
                topicNumber = 3;
            }
            else if (topic.equals("Loop")){
                topicNumber = 4;
            }
            else if (topic.equals("Decision")){
                topicNumber = 5;
            }
            else if (topic.equals("Array")){
                topicNumber = 6;
            }
            else if (topic.equals("Date")){
                topicNumber = 7;
            }
            else if (topic.equals("Method")){
                topicNumber = 8;
            }
            else if (topic.equals("String")){
                topicNumber = 9;
            }
        }
        else if (lang.equals("HTML"))
        {
            if (topic.equals("Intro")){
                topicNumber = 0;
            }
            else if (topic.equals("Basic")){
                topicNumber = 1;
            }
            else if (topic.equals("Headings")){
                topicNumber = 2;
            }
            else if (topic.equals("Paragraph")){
                topicNumber = 3;
            }
            else if (topic.equals("Images")){
                topicNumber = 4;
            }
            else if (topic.equals("Table")){
                topicNumber = 5;
            }
            else if (topic.equals("List")){
                topicNumber = 6;
            }
            else if (topic.equals("Links")){
                topicNumber = 7;
            }
            else if (topic.equals("Text")){
                topicNumber = 8;
            }
            else if (topic.equals("Form")){
                topicNumber = 9;
            }
        }
        if(!isConnected(TestScreen.this)) {
            buildDialog(TestScreen.this).show();
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
        if (mQuestionNumber<=4){
            number.setText((mQuestionNumber+1)+"/5");
        }
        else {
            Intent i = new Intent(TestScreen.this, ResultScreen.class);
            i.putExtra("score", mScore);
            i.putExtra("lang",lang );
            i.putExtra("topic",topic );
            startActivity(i);
            finish();
        }

        mQuestionRef = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/question");
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

        mChoice1Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/choice1");
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
        mChoice2Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/choice2");
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
        mChoice3Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/choice3");
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
        mChoice4Ref = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/choice4");
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
        mAnswerRef = FirebaseDatabase.getInstance("https://datafire-a1741.firebaseio.com").getReference("MCQTest/0/"+lang+"/"+topicNumber+"/"+topic+"/"+mQuestionNumber+"/answer");
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
