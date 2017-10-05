package net.famunity.trial.java.leetcode;

import static java.util.Arrays.binarySearch;

public class _0002_BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[] {1, 3, 5, 8, 10, 15, 18, 25, 30, 32};
        int target = 30;

        int indexOfTarget = binarySearch(array, target);
        int indexOfTarget2 = standardBinarySearch(array, target);
        int indexOfTarget3 = strideBinarySearch(array, target);
        System.out.println(indexOfTarget+"=="+indexOfTarget2+"=="+indexOfTarget3);
    }

    private static int standardBinarySearch(int[] array, int target) {
        int startIndex = 0, endIndex = array.length-1;
        int midIndex;
        while(startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) / 2; // 0 1 2 3 | 4 5 6
            if (array[midIndex] == target) {
                return midIndex;
            } else if (array[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return -1;

    }

    private static int strideBinarySearch(int[] array, int target) {
        int position = 0, size = array.length;
        for (int stride = size/2; stride >= 1; stride = stride/2){
            while (position + stride < size && array[position + stride] <= target){
                position += stride;
            }
        }

        if(array[position] == target) return position;
        return -1;
    }

}
