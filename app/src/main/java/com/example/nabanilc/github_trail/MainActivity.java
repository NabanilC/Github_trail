package com.example.nabanilc.github_trail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Project creation toast", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Toast for checking push", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Toast for checking pull request", Toast.LENGTH_SHORT).show();
    }
}
