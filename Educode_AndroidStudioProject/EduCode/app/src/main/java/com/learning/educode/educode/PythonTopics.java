package com.learning.educode.educode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class PythonTopics extends AppCompatActivity {

    Button intro, decision,variables,operators,date,loops,function,lists,gui,database,finaltest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_topics);

        intro = (Button) findViewById( R.id.intro );
        decision = (Button) findViewById( R.id.decision );
        variables = (Button) findViewById( R.id.variables );
        operators = (Button) findViewById( R.id.operators );
        date = (Button) findViewById( R.id.datetimes);
        loops = (Button) findViewById( R.id.loops);
        function = (Button) findViewById( R.id.functions);
        lists = (Button) findViewById( R.id.lists);
        gui = (Button) findViewById( R.id.gui);
        database = (Button) findViewById( R.id.database );
        finaltest = (Button) findViewById(R.id.pythonFinalTest);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Intro";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Intro");
                startActivity(i);
            }
        });
        decision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Decision";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Decision");
                startActivity(i);
            }
        });
        variables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Variables";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Variables");
                startActivity(i);
            }
        });
        operators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Operators";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Operators");
                startActivity(i);
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Date";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Date");
                startActivity(i);
            }
        });
        loops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Loop";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Loops");
                startActivity(i);
            }
        });
        function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Function";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Function");
                startActivity(i);
            }
        });
        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="List";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "List");
                startActivity(i);
            }
        });
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="GUI";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "GUI");
                startActivity(i);
            }
        });
        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Database";
                i.putExtra("lang", "Python");
                i.putExtra( "topic", "Database");
                startActivity(i);
            }
        });
        finaltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PythonTopics.this, FinalTestScreen.class);
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
                startActivity(new Intent(PythonTopics.this, Dashboard.class));
                finish();
        }
        return false;
    }
}
