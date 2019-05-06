package com.learning.educode.educode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class ViewContent extends AppCompatActivity {

    WebView contentView;
    Button test;
    public String lang, topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);

        contentView = (WebView)findViewById(R.id.contentView);
        test = (Button)findViewById( R.id.test );

        Intent intent = getIntent();
        lang = intent.getStringExtra("lang");
        topic = intent.getStringExtra("topic");

        test.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewContent.this, TestScreen.class);
                i.putExtra( "lang", lang);
                i.putExtra( "topic", topic);
                startActivity(i);
            }
        } );

        contentView.getSettings().setJavaScriptEnabled(true);
        contentView.setWebViewClient(new WebViewClient());

        contentView.loadUrl("file:///android_asset/"+lang+"/"+lang+topic+".html");

    }
}
