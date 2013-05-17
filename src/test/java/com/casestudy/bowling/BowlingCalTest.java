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
        Round firstRound = new Round();
        firstRound.hit(4);
        firstRound.hit(3);
        bowlingCal.addRound(firstRound);
        assertThat(bowlingCal.getTotalScore(),is(7));
        Round secondRound = new Round();
        secondRound.hit(7);
        secondRound.hit(1);
        bowlingCal.addRound(secondRound);
        assertThat(bowlingCal.getTotalScore(),is(15));
    }
}
