package com.androidapplication.capstone.mathemagician;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.androidapplication.capstone.mathemagician.helpers.SessionResult;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HighScoresPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String results = getIntent().getStringExtra("results");
        TextView sessionResultsTextView = (TextView) findViewById(R.id.session_results_text);
        sessionResultsTextView.setText(results);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                goToMainPage();
            }

        }, 3000L);

    }

    public void goToMainPage() {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

}
