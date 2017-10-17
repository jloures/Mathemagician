package com.androidapplication.capstone.mathemagician.helpers;

import java.util.Random;

/**
 * Created by joaoloures on 2017-10-16.
 */

public class Question {

    private float num_1;
    private float num_2;
    private Operator operator;
    private float result;

    public Question(Operator o) {
        Random randomGenerator = new Random();

        this.operator = o;
        this.num_1 = (float) randomGenerator.nextInt(100);
        this.num_2 = (float) randomGenerator.nextInt(100);

        this.result = getResult(o, this.num_1, this.num_2);
    }

    public boolean checkResult(float guess) {
        return guess == this.result;
    }

    private float getResult(Operator o, float a, float b) {
        switch(o) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                return a / b;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return (int)this.num_1 + " " + OperatorManager.getOperatorAsString(this.operator) + " " + (int)this.num_2;
    }
}
