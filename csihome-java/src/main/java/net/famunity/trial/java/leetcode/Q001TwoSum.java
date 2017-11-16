package net.famunity.trial.java.leetcode;


/**
 * https://leetcode.com/problems/two-sum/description/
 *
 *
 */
public class Q001TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        Q001TwoSum q001TwoSum = new Q001TwoSum();
        int[] result = q001TwoSum.twoSum(nums, 9);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
