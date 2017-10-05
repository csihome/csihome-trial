package net.famunity.trial.java.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by csihome on 21/07/2017.
 *
 * Given an array of integers, return INDICES of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class _1001_SumTwo {

    public static void main(String[] args) {

        _1001_SumTwo a1SumTwo = new _1001_SumTwo();

        int[] nums = new int[] {15, 2, 11, 2};
        int target = 4;
        int[] result = a1SumTwo.find1(nums, target);
        System.out.println(result[0]+", "+result[1]);

        nums = new int[] {15, 2, 11, 2, 7, 8};
        target = 9;
        result = a1SumTwo.find2(nums, target);
        System.out.println(result[0]+", "+result[1]);

        nums = new int[] {15, 2, 11, 2, 9, 6};
        target = 17;
        result = a1SumTwo.find3(nums, target);
        System.out.println(result[0]+", "+result[1]);

    }

    public int[] find1(int[] nums, int target){
        int bigO = 0;
        for(int i = 0; i < nums.length; i++){
            bigO++;
            for (int j = i+1; j < nums.length; j++) {
                bigO++;
                if(nums[i] == target - nums[j]){
                    System.out.println("(i, j)=(" + (i+1) + "," + j + "), BigO is "+bigO);
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Available numbers.");
    }

    public int[] find2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No Available numbers.");
    }

    public int[] find3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Available numbers.");
    }
}
