package com.example.challenges.BinarySearch;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class FirstLargerIndexTest {

    @Test
    void sorted_basic() {
        List<Integer> arr1 = Arrays.asList(2, 5, 1);
        List<Integer> arr2 = Arrays.asList(1, 3, 4, 6); // sorted

        List<Integer> got = FirstLargerIndex.findFirstLargerIndex(arr1, arr2);
        System.out.println(got);
        assertEquals(Arrays.asList(2, 4, 2), got); // 1-based indexes
    }

    @Test
    void sorted_allGreaterNotFound() {
        List<Integer> arr1 = Arrays.asList(10, 20);
        List<Integer> arr2 = Arrays.asList(1, 2, 3, 4); // sorted

        List<Integer> got = FirstLargerIndex.findFirstLargerIndex(arr1, arr2);
        System.out.println(got);
        assertEquals(Arrays.asList(-1, -1), got);
    }

    @Test
    void sorted_emptyArr2() {
        List<Integer> arr1 = Arrays.asList(1, 2, 3);
        List<Integer> arr2 = Collections.emptyList();

        List<Integer> got = FirstLargerIndex.findFirstLargerIndex(arr1, arr2);
        assertEquals(Arrays.asList(-1, -1, -1), got);
    }

    @Test
    void nullSafety() {
        assertThrows(NullPointerException.class,
                () -> FirstLargerIndex.findFirstLargerIndex(null, Arrays.asList(1)));
        assertThrows(NullPointerException.class,
                () -> FirstLargerIndex.findFirstLargerIndex(Arrays.asList(1), null));
    }
}
