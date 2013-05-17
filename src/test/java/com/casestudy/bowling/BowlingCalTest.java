package com.casestudy.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BowlingCalTest {

    private BowlingCal bowlingCal;

    @Before
    public void setUp() throws Exception {
        bowlingCal = new BowlingCal();
    }

    @Test
    public void should_sum_total_score_for_normal_round() throws Exception {
        bowlingCal.addRound(generateNormalRound(4, 3));
        assertThat(bowlingCal.getTotalScore(),is(7));
        bowlingCal.addRound(generateNormalRound(7, 1));
        assertThat(bowlingCal.getTotalScore(), is(15));
    }

    private Round generateNormalRound(int hit1, int hit2) {
        Round round = new Round();
        round.hit(hit1);
        round.hit(hit2);
        return round;
    }
}
