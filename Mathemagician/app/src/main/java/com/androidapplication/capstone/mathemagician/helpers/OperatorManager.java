package com.androidapplication.capstone.mathemagician.helpers;

import java.util.Random;

/**
 * Created by joaoloures on 2017-10-16.
 */
public class OperatorManager {
    public static Operator getRandomOperator() {
        Random randomNumberGenerator = new Random();
        switch(randomNumberGenerator.nextInt(4)) {
            case 1:
                return Operator.ADDITION;
            case 2:
                return Operator.DIVISION;
            case 3:
                return Operator.MULTIPLICATION;
            case 4:
                return Operator.SUBTRACTION;
            default:
                return Operator.ADDITION;
        }
    }

    public static String getOperatorAsString(Operator o) {
        switch(o) {
            case ADDITION:
                return "+";
            case DIVISION:
                return "/";
            case MULTIPLICATION:
                return "x";
            case SUBTRACTION:
                return "-";
            default:
                return "";
        }
    }
}
