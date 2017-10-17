package com.androidapplication.capstone.mathemagician.helpers;

import java.util.Random;

/**
 * Created by joaoloures on 2017-10-16.
 */

public class Set {

    private float num_1;
    private float num_2;
    private float result;

    public Set(Operation o) {
        Random randomGenerator = new Random();

        this.num_1 = (float) randomGenerator.nextInt(100);
        this.num_2 = (float) randomGenerator.nextInt(100);

        this.result = getResult(o, this.num_1, this.num_2);
    }

    public boolean checkResult(float guess) {
        return guess == this.result;
    }

    private float getResult(Operation o, float a, float b) {
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

}
