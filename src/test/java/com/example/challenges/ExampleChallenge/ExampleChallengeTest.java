package com.example.challenges.ExampleChallenge;

import com.example.challenges.ExampleChallenge.ExampleChallenge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExampleChallengeTest {

    @Test
    void testAdd() {
        ExampleChallenge challenge = new ExampleChallenge();
        assertEquals(5, challenge.add(2, 3));
    }
}
