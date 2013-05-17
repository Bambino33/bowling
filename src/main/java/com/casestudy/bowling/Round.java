package com.casestudy.bowling;

public class Round {
    public void hit(int score) {
        if (this.score + score > 10) {
            throw new UnsupportedOperationException("Your score is larger than 10");
        }
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    private int score = 0;
}
