package com.androidapplication.capstone.mathemagician;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidapplication.capstone.mathemagician.helpers.Operator;
import com.androidapplication.capstone.mathemagician.helpers.OperatorManager;
import com.androidapplication.capstone.mathemagician.helpers.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //generate problem set
        //TODO change the number once you are able to get user input
        ArrayList<Question> questions = this.generateQuestionSets(50);
    }

    //this should be inside its own separate class
    private ArrayList<Question> generateQuestionSets(int numQuestions) {
        //at first, this will only do addition
        ArrayList<Question> questions = new ArrayList<Question>();
        for(int i = 0; i < numQuestions; i++) {
            questions.add(new Question(
                    //change here to make the type of operation constant
                    OperatorManager.getRandomOperator()
            ));
        }

        return questions;
    }
}
