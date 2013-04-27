package com.casestudy.bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: Zhengjie
 * Date: 13-4-27
 * Time: 下午4:05
 * To change this template use File | Settings | File Templates.
 */
public class RoundTest {
    @Test
    public void should_sum_scores_for_normal_round() throws Exception {
        Round round = new Round();
        round.hit(4);
        assertThat(round.getScore(), is(4));
        round.hit(3);
        assertThat(round.getScore(), is(7));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_sum_score_larger_than_ten() throws Exception {
        Round round = new Round();
        round.hit(11);
    }

    @Test
    public void should_not_sum_score_if_found_total_score_is_larger_than_10() throws Exception {
        Round round  = new Round();
        round.hit(6);
        try{
            round.hit(5);
        }   catch(Exception e){

        }
        assertThat(round.getScore(),is(6));
    }
}
