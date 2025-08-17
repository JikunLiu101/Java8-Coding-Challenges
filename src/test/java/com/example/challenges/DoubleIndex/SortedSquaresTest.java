package com.example.challenges.DoubleIndex;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SortedSquaresTest {

    @Test
    void mixedNegZeroPos() {
        List<Integer> in = Arrays.asList(-4, -1, 0, 3, 10);
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertEquals(Arrays.asList(0, 1, 9, 16, 100), out);
    }

    @Test
    void allNegativeDescending() {
        List<Integer> in = Arrays.asList(-7, -3, -1);
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertEquals(Arrays.asList(1, 9, 49), out);
    }

    @Test
    void allNonNegative() {
        List<Integer> in = Arrays.asList(0, 1, 2, 3);
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertEquals(Arrays.asList(0, 1, 4, 9), out);
    }

    @Test
    void duplicatesAndZeros() {
        List<Integer> in = Arrays.asList(-2, -2, 0, 2);
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertEquals(Arrays.asList(0, 4, 4, 4), out);
    }

    @Test
    void emptyInput() {
        List<Integer> in = Collections.emptyList();
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertTrue(out.isEmpty());
    }

    @Test
    void boundaryWithinIntSquare() {
        // 46340^2 fits in int
        List<Integer> in = Arrays.asList(-46340, 46340);
        List<Integer> out = SortedSquares.sortedSquares(in);
        assertEquals(Arrays.asList(2147395600, 2147395600), out);
    }

    @Test
    void minValueOverflowsSquare() {
        List<Integer> in = Arrays.asList(Integer.MIN_VALUE, 0);
        assertThrows(ArithmeticException.class, () -> SortedSquares.sortedSquares(in));
    }

    @Test
    void nullInputThrows() {
        assertThrows(NullPointerException.class, () -> SortedSquares.sortedSquares(null));
    }
}
