package net.famunity.trial.java.algorithm;

public class _0001_Quicksort {
    public static void main(String[] args) {

        int[] nums = new int[] {1, 12, 5, 26, 7, 14, 3, 7, 2};
        for (int i: nums) {
            System.out.print(i+",");
        }

        System.out.println("====>");
        sort(nums);
        for (int i: nums) {
            System.out.print(i+",");
        }
    }

    public static void sort(int[] nums){
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        quicksort(nums, leftIndex, rightIndex);
    }

    private static int[] quicksort(int[] nums, int leftIndex, int rightIndex) {
        int pivotIndex = partition(nums, leftIndex, rightIndex);

        if(leftIndex<pivotIndex-1)
            quicksort(nums, leftIndex, pivotIndex-1);

        if(rightIndex>pivotIndex){
            quicksort(nums, pivotIndex, rightIndex);
        }

        return nums;
    }

    private static int partition(int[] nums, int leftIndex, int rightIndex) {
        int pivot = nums[(leftIndex+rightIndex)/2];

        while(leftIndex <= rightIndex){

            while(nums[leftIndex] < pivot){
                leftIndex++;
            }

            while(nums[rightIndex] > pivot){
                rightIndex--;
            }

            if(leftIndex <= rightIndex) {
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = tmp;
                leftIndex++;
                rightIndex--;
            }

        }

        return leftIndex;
    }


}
