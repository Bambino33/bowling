package com.casestudy.bowling;

/**
 * Created with IntelliJ IDEA.
 * User: Zhengjie
 * Date: 13-4-27
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public class Round  {
    public void hit(int score) {
           if(this.score+score>10){
               throw new UnsupportedOperationException("Your score is larger than 10");
           }
           this.score += score;
    }

    public int getScore() {
        return score;
    }
        private int score = 0;
}
