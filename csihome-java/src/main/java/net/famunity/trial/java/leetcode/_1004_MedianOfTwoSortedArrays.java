package net.famunity.trial.java.leetcode;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class _1004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {10, 20, 30, 40};
        int[] nums2 = new int[] {31, 32};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length + nums2.length) % 2 == 1) {
            // If combination of 2 arrays is odd number, we find the mid one
            return findKthInTwoSortedArrays(nums1, nums2, (nums1.length+nums2.length)/2 + 1);
        } else {

            // If combination of 2 arrays is even number, we find the mid two, and get average.
            return (findKthInTwoSortedArrays(nums1, nums2, (nums1.length+nums2.length)/2) +
                    findKthInTwoSortedArrays(nums1, nums2, (nums1.length+nums2.length)/2 + 1)) / 2.0;
        }
    }

    public static int findKthInTwoSortedArrays (int[] nums1, int[] nums2, int k) {
        int nums1s = nums1.length;
        int nums2s = nums2.length;

        // Make sure nums1 is smaller array
        if (nums1s > nums2s) {
            return findKthInTwoSortedArrays(nums2, nums1, k);
        }

        // left = starter index of smaller array
        // right = end index of smaller array + 1
        int left = 0, right = nums1s, kth = k-1;

        while(left < right){
            int mid = left + (right - left) / 2; // middle one's index of smaller array
            if (0 <= kth-mid && kth-mid < nums2s && nums1[mid] >= nums2[kth-mid]){ // middle of combination
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int nums1K = left-1 >= 0 ? nums1[left-1] : Integer.MIN_VALUE;
        int nums2K = kth-left > 0 ? nums2[kth-left] : Integer.MIN_VALUE;

        return Math.max(nums1K, nums2K);
    }
}
