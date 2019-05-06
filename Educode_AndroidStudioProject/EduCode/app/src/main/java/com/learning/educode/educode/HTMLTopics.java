package com.learning.educode.educode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class HTMLTopics extends AppCompatActivity {

    Button headings, intro, basic, images,links,lists,paragraph,tables,text,forms, finaltest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmltopics);

        intro = (Button) findViewById( R.id.intro );
        basic = (Button) findViewById( R.id.basic );
        headings = (Button) findViewById( R.id.headings );
        images = (Button) findViewById( R.id.images);
        links = (Button) findViewById( R.id.links);
        lists = (Button) findViewById( R.id.listbtn);
        paragraph = (Button) findViewById( R.id.paragraphs);
        forms = (Button) findViewById( R.id.form);
        text = (Button) findViewById( R.id.headings);
        tables = (Button) findViewById( R.id.table);
        finaltest = (Button)findViewById(R.id.htmlFinalTest);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Intro";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Intro");
                startActivity(i);
            }
        });
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Basic";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Basic");
                startActivity(i);
            }
        });
        headings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Headings";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Headings");
                startActivity(i);
            }
        });
        images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Images";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Images");
                startActivity(i);
            }
        });
        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Links";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Links");
                startActivity(i);
            }
        });
        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="List";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "List");
                startActivity(i);
            }
        });
        paragraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Paragraph";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Paragraph");
                startActivity(i);
            }
        });
        tables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Table";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Table");
                startActivity(i);
            }
        });
        forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Form";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Form");
                startActivity(i);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, ViewContent.class);
                Intent intent = getIntent();
                String extra = intent.getStringExtra("lang");
                extra+="Text";
                i.putExtra("lang", "HTML");
                i.putExtra( "topic", "Text");
                startActivity(i);
            }
        });
        finaltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HTMLTopics.this, FinalTestScreen.class);
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
                startActivity(new Intent(HTMLTopics.this, Dashboard.class));
                finish();
        }
        return false;
    }
}
