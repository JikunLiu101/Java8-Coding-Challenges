package com.example.challenges.DoubleIndex;

import java.util.List;
import java.util.Objects;

public class RemoveElement {
    public static Integer removeElement(List<Integer> nums, Integer val){
        Objects.requireNonNull(nums);
        int slowIndex = 0;
        for (int fastIndex=0; fastIndex<nums.size(); fastIndex++){
            if (!Objects.equals(nums.get(fastIndex), val)){
                nums.set(slowIndex, nums.get(fastIndex));
                slowIndex++;
            }
        }
        if (slowIndex < nums.size()){
            nums.subList(slowIndex, nums.size()).clear();
        }
        return slowIndex;
    }
}
