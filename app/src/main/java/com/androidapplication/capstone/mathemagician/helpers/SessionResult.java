package com.androidapplication.capstone.mathemagician.helpers;

/**
 * Created by joaoloures on 2017-10-16.
 */
public class SessionResult {
    public int duration;
    public int numMistakes;

    public SessionResult (int duration, int numMistakes) {
        this.duration = duration;
        this.numMistakes = numMistakes;
    }

    @Override
    public String toString() {
        return "Mistakes: " + this.numMistakes + "\nTime: " + this.duration + " seconds.";
    }
}
