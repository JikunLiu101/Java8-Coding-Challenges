package com.example.challenges.DoubleIndex;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @Test
    void basicRemoval() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 2, 3));
        int k = RemoveElement.removeElement(nums, 3);
        assertEquals(2, k);
        assertEquals(Arrays.asList(2, 2), nums);
    }

    @Test
    void noRemoval() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        int k = RemoveElement.removeElement(nums, 99);
        assertEquals(3, k);
        assertEquals(Arrays.asList(1, 2, 3), nums);
    }

    @Test
    void allRemoved() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 5, 5));
        int k = RemoveElement.removeElement(nums, 5);
        assertEquals(0, k);
        assertTrue(nums.isEmpty());
    }

    @Test
    void handlesDuplicatesInterspersed() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2));
        int k = RemoveElement.removeElement(nums, 2);
        assertEquals(3, k);
        assertEquals(Arrays.asList(1, 3, 4), nums);
    }

    @Test
    void emptyList() {
        List<Integer> nums = new ArrayList<>();
        int k = RemoveElement.removeElement(nums, 1);
        assertEquals(0, k);
        assertTrue(nums.isEmpty());
    }

    @Test
    void nullValRemovesNulls() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(null, 1, null, 2, 3, null));
        int k = RemoveElement.removeElement(nums, null);
        assertEquals(3, k);
        assertEquals(Arrays.asList(1, 2, 3), nums);
    }

    @Test
    void nullElementsButNonNullVal() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(null, 1, 2, null, 3));
        int k = RemoveElement.removeElement(nums, 2);
        assertEquals(4, k);
        assertEquals(Arrays.asList(null, 1, null, 3), nums);
    }

    @Test
    void largeInputSanity() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 1000; i++) nums.add(i % 5); // 0..4 repeating
        int k = RemoveElement.removeElement(nums, 3);
        assertEquals(800, k); // 1/5 are 3s removed
        // Ensure no 3s remain
        assertFalse(nums.contains(3));
        // Size trimmed correctly
        assertEquals(800, nums.size());
    }

    @Test
    void nullListThrows() {
        assertThrows(NullPointerException.class, () -> RemoveElement.removeElement(null, 1));
    }
}
