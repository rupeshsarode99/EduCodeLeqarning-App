package com.learning.educode.educode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    ImageButton JAVA, PYTHON, PHP, HTML;
    TextView PythonProgress, JavaProgress, PHPProgress, HTMLProgress;

    int pythonCount = 0, javaCount = 0, HTMLCount = 0, PHPCount = 0;
    int p = 0, j = 0, h = 0, ph = 0;

    private boolean doubleBackToExitPressedOnce = false;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        PythonProgress = (TextView)findViewById(R.id.PythonProgress);
        HTMLProgress = (TextView)findViewById(R.id.HTMLProgress);
        PHPProgress = (TextView)findViewById(R.id.PHPProgress);
        JavaProgress = (TextView)findViewById(R.id.JavaProgress);

        JAVA = (ImageButton)findViewById(R.id.JAVA);
        PYTHON = (ImageButton) findViewById(R.id.PYTHON);
        HTML = (ImageButton) findViewById(R.id.HTML);
        PHP = (ImageButton) findViewById(R.id.PHP);

        JAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, JavaTopics.class);
                i.putExtra( "lang", "Java");
                startActivity(i);
            }
        });
        PYTHON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, PythonTopics.class);
                i.putExtra( "lang", "Python");
                startActivity(i);
            }
        });
        HTML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, HTMLTopics.class);
                i.putExtra( "lang", "HTML");
                startActivity(i);
            }
        });
        PHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, PHPTopics.class);
                i.putExtra( "lang", "PHP");
                startActivity(i);
            }
        });

        SharedPreferences preferences = Dashboard.this.getSharedPreferences("Mydata", MODE_PRIVATE);

        String[] PythonArray = new String[] {"PythonIntro","PythonDatabase","PythonDecision","PythonDate","PythonFunction","PythonGUI","PythonList",
                "PythonLoops","PythonOperators","PythonVariable"};
        String[] JavaArray = new String[] {"JavaArray","JavaBasic","JavaDate","JavaDecision","JavaIntro","JavaLoop","JavaMethod",
                "JavaOperator","JavaString","JavaVariable"};
        String[] PHPArray = new String[] {"PHPDatatypes","PHPFor","PHPIf","PHPIntro","PHPOperators","PHPString","PHPSwitch",
                "PHPSyntax","PHPWhile","PHPVariables"};
        String[] HTMLArray = new String[] {"HTMLBasic","HTMLForm","HTMLHeadings","HTMLImages","HTMLIntro","HTMLList","HTMLLinks",
                "HTMLParagraph","HTMLTable","HTMLText"};

        for (String i : PythonArray)
        {
            p = preferences.getInt(i, 0);
            pythonCount = p + pythonCount;
//            PythonProgress.setText(preferences.getString(i, "Not Found"));
        }
        if (pythonCount != 0){
            PythonProgress.setText(" "+pythonCount+"%");
        }

        for (String i : JavaArray)
        {
            j = preferences.getInt(i, 0);
            javaCount = j + javaCount;
        }
        if (javaCount != 0) {
            JavaProgress.setText(" " + javaCount + "%");
        }
        for (String i : HTMLArray)
        {
            h = preferences.getInt(i, 0);
            HTMLCount = h + HTMLCount;
        }
        if (HTMLCount != 0) {
            HTMLProgress.setText(" " + HTMLCount + "%");
        }
        for (String i : PHPArray)
        {
            ph = preferences.getInt(i, 0);
            PHPCount = ph + PHPCount;
        }
        if (PHPCount != 0) {
            PHPProgress.setText(" " + PHPCount + "%");
        }
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.logOut:
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                startActivity(new Intent(Dashboard.this, LoginScreen.class));
                finish();

                break;
        }

        return true;
    }
}
