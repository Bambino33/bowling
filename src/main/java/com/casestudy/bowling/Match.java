package com.casestudy.bowling;

import com.google.common.collect.Lists;

import java.util.List;

public class Match {
    public static final int FULL_SCORE = 10;
    public static final int TWO_ROUND = 2;
    private List<Integer> roundHits = Lists.newArrayList();
    private int totalScore;

    public void hit(int score) {
        if(isRoundOutOfScore(score)){
            throw new UnsupportedOperationException("Should not larger than 10");
        }
        if(isLastRoundSpare()){
            sumScoreForSpareRound(score);
        }
        this.roundHits.add(score);
        if(isNormalRound()){
            sumScoreForNormalRound();
        }
    }

    private void sumScoreForNormalRound() {
        this.totalScore += sumRound();
        roundHits.clear();
    }

    private void sumScoreForSpareRound(int score) {
        this.totalScore += sumRound();
        this.totalScore += score;
        roundHits.clear();
    }

    private boolean isRoundOutOfScore(int score) {
        return score+sumRound()>10&&roundHits.size()< TWO_ROUND;
    }

    private boolean isNormalRound() {
        return roundHits.size()==2&&sumRound()<FULL_SCORE;
    }

    private boolean isLastRoundSpare() {
        return sumRound()== FULL_SCORE;
    }

    private int sumRound() {
        int roundScore = 0;
        for(Integer hit:roundHits){
            roundScore += hit;
        }
        return roundScore;
    }

    public int getScore() {
        return totalScore;
    }


}
