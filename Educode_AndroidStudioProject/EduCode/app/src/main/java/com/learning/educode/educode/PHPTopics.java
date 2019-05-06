package com.learning.educode.educode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class PHPTopics extends AppCompatActivity {

    Button intro, syntax, data,variables,operators,ifStatement,switchStatement,forLoop,whileLoop, stringFunction,finaltest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phptopics);

        intro = (Button) findViewById( R.id.intro );
        data = (Button) findViewById( R.id.datatypes );
        variables = (Button) findViewById( R.id.variables );
        operators = (Button) findViewById( R.id.operators );
        syntax = (Button) findViewById( R.id.syntax);
        ifStatement = (Button) findViewById( R.id.ifStatement);
        switchStatement = (Button) findViewById( R.id.switchStatement);
        forLoop = (Button) findViewById( R.id.forLoop);
        whileLoop = (Button) findViewById( R.id.whileLoop);
        stringFunction = (Button) findViewById( R.id.stringFunction);
        finaltest = (Button) findViewById(R.id.phpFinalTest);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Intro";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Intro");
                startActivity(i);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Datatypes";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Datatypes");
                startActivity(i);
            }
        });
        variables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Variables";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Variables");
                startActivity(i);
            }
        });
        operators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Operators";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Operators");
                startActivity(i);
            }
        });
        syntax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Syntax";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Syntax");
                startActivity(i);
            }
        });
        forLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="For";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "For");
                startActivity(i);
            }
        });
        whileLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="While";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "While");
                startActivity(i);
            }
        });
        ifStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="If";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "If");
                startActivity(i);
            }
        });
        switchStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Switch";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "Switch");
                startActivity(i);
            }
        });
        stringFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="String";
                i.putExtra("lang", "PHP");
                i.putExtra( "topic", "String");
                startActivity(i);
            }
        });
        finaltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PHPTopics.this, FinalTestScreen.class);
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
                startActivity(new Intent(PHPTopics.this, Dashboard.class));
                finish();
        }
        return false;
    }
}
