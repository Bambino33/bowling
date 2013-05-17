package com.casestudy.bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatchTest {
    @Test
    public void should_sum_scores_for_normal_round() throws Exception {
        Match match = new Match();
        match.hit(4);
        assertThat(match.getScore(), is(4));
        match.hit(3);
        assertThat(match.getScore(), is(7));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_sum_score_larger_than_ten() throws Exception {
        Match match = new Match();
        match.hit(11);
    }

    @Test
    public void should_not_sum_score_if_found_total_score_is_larger_than_10() throws Exception {
        Match match = new Match();
        match.hit(6);
        try {
            match.hit(5);
        } catch (Exception e) {

        }
        assertThat(match.getScore(), is(6));
    }

    @Test
    public void should_sum_scores_for_two_normal_round() throws Exception {
        Match match = new Match();
        match.hit(4);
        assertThat(match.getScore(), is(4));
        match.hit(3);
        assertThat(match.getScore(), is(7));
        match.hit(4);
        assertThat(match.getScore(), is(11));
        match.hit(3);
        assertThat(match.getScore(), is(14));
    }

    @Test
    public void should_sum_scores_for_spare_round() throws Exception {
        Match match = new Match();
        match.hit(4);
        assertThat(match.getScore(), is(4));
        match.hit(6);
        match.hit(4);
        match.hit(3);
        assertThat(match.getScore(), is(21));
    }

    @Test
    public void should_sum_scores_for_strike_round() throws Exception {
        Match match = new Match();
        match.hit(10);
        assertThat(match.getScore(), is(10));
        match.hit(4);
        match.hit(3);
        assertThat(match.getScore(), is(24));
    }
}
