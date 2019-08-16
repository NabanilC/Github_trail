package com.example.nabanilc.github_trail;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.AddTrace;
import com.google.firebase.perf.metrics.Trace;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    String screenName;
    Bundle params;

    @Override
    @AddTrace(name = "onCreateTrace", enabled = true /* optional */)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screenName= this.getPackageName().getClass().getName();
        Toast.makeText(this, "Project creation toast", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Toast for checking push", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Toast for checking pull request", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "112233", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "8899", Toast.LENGTH_SHORT).show();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);



        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });


    }


    @Override
    @AddTrace(name = "onResumeTrace", enabled = true /* optional */)
    protected void onResume() {

        super.onResume();
        mFirebaseAnalytics.setCurrentScreen(this, screenName, MainActivity.class.getSimpleName());
        mFirebaseAnalytics.setMinimumSessionDuration(100L);
        params = new Bundle();
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "screen");
        params.putString(FirebaseAnalytics.Param.ITEM_NAME, screenName);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params);

    }

}
