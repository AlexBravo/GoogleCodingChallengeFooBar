package com.alexbravo.googlecodingchallengefoobar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MinionInterrogationTest {
    @Test
    public void short_test() throws Exception {
        int minions[][] = {{5, 1, 5}, {10, 1, 2}};
        int correct_answer[] = {1, 0};
        int answer[] = MinionInterrogation.answer(minions);
        assertArrayEquals(correct_answer, answer);
    }

    @Test
    public void long_test() throws Exception {
        int minions[][] = {{390, 185, 624}, {686, 351, 947}, {276, 1023, 1024}, {199, 148, 250}};
        int correct_answer[] = {2, 3, 0, 1};
        int answer[] = MinionInterrogation.answer(minions);
        assertArrayEquals(correct_answer, answer);
    }
}