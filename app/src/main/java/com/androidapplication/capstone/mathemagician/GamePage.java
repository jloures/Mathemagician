package com.androidapplication.capstone.mathemagician;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapplication.capstone.mathemagician.helpers.Operator;
import com.androidapplication.capstone.mathemagician.helpers.Question;
import com.androidapplication.capstone.mathemagician.helpers.SessionResult;

import java.util.ArrayList;

public class GamePage extends AppCompatActivity {

    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private int numMistakes = 0;
    private int numQuestions;
    private long startTime;
    private long endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //generate problem set
        //TODO change the number once you are able to get user input
        this.numQuestions = 50;
        this.questions = this.generateQuestionSets(this.numQuestions);
        this.startTime = System.currentTimeMillis();
        this.displayQuestion(this.currentQuestionIndex);
    }

    //this should be inside its own separate class
    private ArrayList<Question> generateQuestionSets(int numQuestions) {
        //at first, this will only do addition
        ArrayList<Question> questions = new ArrayList<Question>();
        for(int i = 0; i < numQuestions; i++) {
            questions.add(new Question(
                    //change here to make the type of operation constant
                    Operator.ADDITION
            ));
        }

        return questions;
    }

    public void submitAnswer(View view) {
        TextView answerTextView = (TextView) findViewById(R.id.answer_text);
        String answerString = answerTextView.getText().toString();

        TextView questionText = (TextView) findViewById(R.id.question_text);
        try {
            float answerFloat = (float) Float.parseFloat(answerString);
            //get the current question object
            Question currentQuestion = this.questions.get(this.currentQuestionIndex);

            if(currentQuestion.checkResult(answerFloat)) {
                //got the answer right, go to the next one
                if(this.currentQuestionIndex == (this.questions.size() - 1)) {
                    this.goToHighScorePage();
                } else {
                    this.displayQuestion(++this.currentQuestionIndex);
                    questionText.setTextColor(Color.BLACK);
                }
            } else {
                //make question text red
                this.displayNumMistakes(++this.numMistakes);
                questionText.setTextColor(Color.RED);
            }
        } catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "Not a number!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        answerTextView.setText("");
    }

    private void displayQuestion(int questionNumber) {
        Question currentQuestion = this.questions.get(questionNumber);
        TextView questionText = (TextView) findViewById(R.id.question_text);
        questionText.setText(currentQuestion.toString());
        this.displayNumMistakes(this.numMistakes);
    }

    private void goToHighScorePage() {
        //save score before and record the time
        this.endTime = System.currentTimeMillis();
        int duration = (int) (this.endTime - this.startTime) / 1000;

        SharedPreferences.Editor editor = getSharedPreferences("high_scores", MODE_PRIVATE).edit();
        //editor.putString();
        editor.apply();

        Intent highScorePageIntent = new Intent(this, HighScoresPage.class);
        highScorePageIntent.putExtra("results", new SessionResult(duration, this.numMistakes).toString());
        startActivity(highScorePageIntent);
    }

    private void displayNumMistakes(int numMistakes) {
        TextView numMistakesText = (TextView) findViewById(R.id.num_mistakes_text);
        numMistakesText.setText("Mistakes: " + numMistakes);
    }
}
