package com.example.challenges.DoubleIndex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SortedSquares {
    public static List<Integer> sortedSquares(List<Integer> arr){
        Objects.requireNonNull(arr);
        int left = 0;
        int right = arr.size()-1;
        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        int index = arr.size()-1;
        while (left <= right){
            int lv = arr.get(left);
            int rv = arr.get(right);
            long la = Math.abs((long) lv);
            long ra = Math.abs((long) rv);

            int square;
            if (la > ra) {
                long sq = la * la;
                if (sq > Integer.MAX_VALUE) throw new ArithmeticException("square overflows int: " + lv);
                square = (int) sq;
                left++;
            } else {
                long sq = ra * ra;
                if (sq > Integer.MAX_VALUE) throw new ArithmeticException("square overflows int: " + rv);
                square = (int) sq;
                right--;
            }
            result.set(index--, square);
        }
        return result;
    }
}
