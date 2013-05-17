package com.casestudy.bowling;

public class Match {
    public void hit(int bottles) {
        if (FirstHitInRound) {
            CurrentRound++;
            BottlesDown[2*(CurrentRound-1)] = bottles;
            FirstHitInRound = false;
            if(10 == bottles){
                FirstHitInRound = true;
            }
        }
        else {
            BottlesDown[2*(CurrentRound-1)+1] = bottles;
            FirstHitInRound = true;
        }
        BottlesDownInOneRound = 0;
        BottlesDownInOneRound = BottlesDown[2*(CurrentRound-1)] + BottlesDown[2*(CurrentRound-1)+1];

        if (BottlesDownInOneRound > 10){
            if (FirstHitInRound){
                BottlesDown[2*(CurrentRound-1)+1] = 0;
            }
            else {
                BottlesDown[2*(CurrentRound-1)] = 0;
            }
            throw new UnsupportedOperationException("BottlesDownInOneRound is larger than 10");
        }
    }

    public int getScore() {
        score = 0;
        for (int i = 1; i <= CurrentRound; i++)     {
            BottlesDownInOneRound = 0;
            BottlesDownInOneRound =  BottlesDown[2*(i-1)] + BottlesDown[2*(i-1)+1];
            if(BottlesDownInOneRound < 10 ){
                score += BottlesDownInOneRound;
            }
            else
            {
                if(BottlesDownInOneRound == 10){
                    if(10 == BottlesDown[2*(i-1)] ){
                        int Next2HitBottles = BottlesDown[2*i]+ BottlesDown[2*i+1];
                        score += BottlesDownInOneRound +Next2HitBottles;
                    }
                    else{
                        int NextHitBottles = BottlesDown[2*i];
                        score += BottlesDownInOneRound +NextHitBottles;
                    }
                }
            }
        }
        return score;
    }

    private int score = 0;
    private final int MaxHitNum = 21;
    private int[] BottlesDown = new int[MaxHitNum];
    private int BottlesDownInOneRound = 0;
    private int CurrentRound = 0;
    private boolean FirstHitInRound = true;

}
