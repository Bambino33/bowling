package com.casestudy.bowling;

import com.google.common.collect.Lists;

import java.util.List;

public class BowlingCal {
    private List<Round> rounds = Lists.newArrayList();

    public void addRound(Round round) {
        this.rounds.add(round);
    }

    public int getTotalScore() {
        int totalScore = 0;
        for (Round round:rounds){
            totalScore += round.getScore();
        }
        return totalScore;
    }
}
