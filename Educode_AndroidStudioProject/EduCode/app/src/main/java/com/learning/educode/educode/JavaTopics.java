package com.learning.educode.educode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class JavaTopics extends AppCompatActivity {

    Button arraybtn, intro, basic, datebtn,variable,operator,decision1,loop,method,stringFunction,finaltest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_topics);

        intro = (Button) findViewById( R.id.intro );
        basic = (Button) findViewById( R.id.basic );
        variable = (Button) findViewById( R.id.variable );
        operator = (Button) findViewById( R.id.operator );
        datebtn = (Button) findViewById( R.id.datebtn);
        method = (Button) findViewById( R.id.method);
        decision1 = (Button) findViewById( R.id.decision);
        loop = (Button) findViewById( R.id.loop);
        arraybtn = (Button) findViewById( R.id.arraybtn);
        stringFunction = (Button) findViewById( R.id.stringbtn);
        finaltest = (Button) findViewById(R.id.javaFinalTest);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Intro";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Intro");
                startActivity(i);
            }
        });
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Basic";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Basic");
                startActivity(i);
            }
        });
        variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Variable";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Variable");
                startActivity(i);
            }
        });
        operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Operator";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Operator");
                startActivity(i);
            }
        });
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Date";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Date");
                startActivity(i);
            }
        });
        method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Method";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Method");
                startActivity(i);
            }
        });
        decision1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Decision";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Decision");
                startActivity(i);
            }
        });
        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Loop";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Loop");
                startActivity(i);
            }
        });
        arraybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Array";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "Array");
                startActivity(i);
            }
        });
        stringFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="String";
                i.putExtra("lang", "Java");
                i.putExtra( "topic", "String");
                startActivity(i);
            }
        });
        finaltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTopics.this, FinalTestScreen.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Intro";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Intro");
                startActivity(i);
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                startActivity(new Intent(JavaTopics.this, Dashboard.class));
                finish();

        }
        return false;
    }
}
