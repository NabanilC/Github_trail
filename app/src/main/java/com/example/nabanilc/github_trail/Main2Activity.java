package com.example.nabanilc.github_trail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.metrics.AddTrace;

public class Main2Activity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    String screenName;
    Bundle params;

    @Override
    @AddTrace(name = "onCreateTrace", enabled = true /* optional */)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        screenName = this.getPackageName().getClass().getName();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

    @Override
    @AddTrace(name = "onResumeTrace", enabled = true /* optional */)
    protected void onResume() {
        super.onResume();
        mFirebaseAnalytics.setCurrentScreen(this, screenName, Main2Activity.class.getSimpleName());
        mFirebaseAnalytics.setMinimumSessionDuration(100L);
        params = new Bundle();
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "screen");
        params.putString(FirebaseAnalytics.Param.ITEM_NAME, screenName);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, params);
    }
}
