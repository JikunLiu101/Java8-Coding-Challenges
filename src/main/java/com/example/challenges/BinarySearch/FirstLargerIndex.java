package com.example.challenges.BinarySearch;

import java.util.*;

public class FirstLargerIndex {
    /**
     * return a 1-based index list, the result[i] is the first element in arr2 larger than i-th element in arr1
     * @param arr1
     * @param arr2
     * @return
     */
    public static List<Integer> findFirstLargerIndex(List<Integer> arr1, List<Integer> arr2){
        Objects.requireNonNull(arr1);
        Objects.requireNonNull(arr2);
        List<Integer> result = new ArrayList<>();
        int m = arr2.size();
        Integer[] idx = new Integer[m];
        for (int i=0;i<m;i++) idx[i] = i;
        Arrays.sort(idx, Comparator.comparingInt(arr2::get));
        arr2.sort(Comparator.naturalOrder());
        for (int a : arr1){
            Integer index = binarySearchFirstLargerIndex(a, arr2);
            if (index < 0) {
                result.add(index);
            } else {
                result.add(idx[index]+1);
            }
        }
        return result;
    }

    public static Integer binarySearchFirstLargerIndex(Integer target, List<Integer> nums){
        int left = 0;
        int right = nums.size()-1;
        int mid;
        int result = -1;
        while (left <= right){
            mid = (left+right)/2;
            if (target < nums.get(mid)){
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }
}
