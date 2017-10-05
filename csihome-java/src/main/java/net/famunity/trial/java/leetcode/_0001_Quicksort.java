package net.famunity.trial.java.leetcode;

public class _0001_Quicksort {
    public static void main(String[] args) {

        int[] nums = new int[] {1, 12, 5, 26, 7, 14, 26, 17, 23};
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

        if(leftIndex<pivotIndex-1) {
            System.out.println(String.format("leftIndex(%s) < pivotIndex-1(%s)", leftIndex, pivotIndex-1));
            quicksort(nums, leftIndex, pivotIndex - 1);
        }

        if(rightIndex>pivotIndex){
            System.out.println(String.format("rightIndex(%s) < pivotIndex(%s)", rightIndex, pivotIndex));
            quicksort(nums, pivotIndex, rightIndex);
        }

        return nums;
    }

    private static int partition(int[] nums, int leftIndex, int rightIndex) {
        int pivot = nums[(leftIndex+rightIndex)/2];
        System.out.println("pivot="+pivot);

        System.out.println(String.format("leftIndex(%s) %s rightIndex(%s)", leftIndex, leftIndex<=rightIndex?"<=":">", rightIndex));
        while(leftIndex <= rightIndex){

            System.out.println(String.format("leftIndex nums[%s]=%s %s %s", leftIndex, nums[leftIndex], nums[leftIndex]<pivot?"<":">=(should switch to right)", pivot));
            while(nums[leftIndex] < pivot){
                leftIndex++;
                System.out.println(String.format("leftIndex nums[%s]=%s %s %s", leftIndex, nums[leftIndex], nums[leftIndex]<pivot?"<":">=(should switch to right)", pivot));
            }

            System.out.println(String.format("rightIndex nums[%s]=%s %s %s", rightIndex, nums[rightIndex], nums[rightIndex]<=pivot?"<=(should switch to left)":">=", pivot));
            while(nums[rightIndex] > pivot){
                rightIndex--;
                System.out.println(String.format("rightIndex nums[%s]=%s %s %s", rightIndex, nums[rightIndex], nums[rightIndex]<=pivot?"<=(should switch to left)":">=", pivot));
            }

            System.out.println(String.format("leftIndex(%s) %s rightIndex(%s)", leftIndex, leftIndex<=rightIndex?"<=":">", rightIndex));
            if(leftIndex <= rightIndex) {
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = tmp;
                System.out.println(String.format("left and rightIndex nums[%s]=%s, nums[%s]=%s", leftIndex, nums[leftIndex], rightIndex, nums[rightIndex]));
                leftIndex++;
                rightIndex--;
                System.out.println(String.format("leftIndex(%s) %s rightIndex(%s)", leftIndex, leftIndex<=rightIndex?"<=":">", rightIndex));
            }

        }

        System.out.println("return leftIndex="+leftIndex);
        return leftIndex;
    }


}
