package com.example.challenges.HashTable;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoArrayIntersectionTest {

    @Test
    void testBasicIntersection() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(3, 4);

        List<Integer> result = TwoArrayIntersection.findIntersection(a, b);
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void testNoIntersection() {
        List<Integer> a = Arrays.asList(1, 2);
        List<Integer> b = Arrays.asList(3, 4);
        List<Integer> result = TwoArrayIntersection.findIntersection(a, b);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFullIntersection() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3);

        List<Integer> result = TwoArrayIntersection.findIntersection(a, b);
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    void testWithDuplicates() {
        List<Integer> a = Arrays.asList(1, 2, 2, 3);
        List<Integer> b = Arrays.asList(2, 2, 4);
        List<Integer> expected = Arrays.asList(2); // unique intersection only

        List<Integer> result = TwoArrayIntersection.findIntersection(a, b);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyInputs() {
        List<Integer> result = TwoArrayIntersection.findIntersection(Collections.emptyList(), Arrays.asList(1, 2));
        assertTrue(result.isEmpty());
    }

    @Test
    void testNullSafe() {
        assertEquals(Collections.EMPTY_LIST, TwoArrayIntersection.findIntersection(null, Arrays.asList(1)));
    }
}
