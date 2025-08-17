package com.example.challenges.HashTable;

import java.util.*;

public class TwoArrayIntersection {
    public static List<Integer> findIntersection(List<Integer> arrayA, List<Integer> arrayB){
        if (arrayA == null || arrayB == null || arrayA.isEmpty() || arrayB.isEmpty()){
            return new ArrayList<>();
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>(arrayA);
        for (int b : arrayB){
            if (set.contains(b)){
                result.add(b);
            }
        }
        return new ArrayList<>(result);
    }
}
