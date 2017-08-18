package net.famunity.trial.java.codility;

/**
 * Peaks
 * Divide an array into the maximum number of same-sized blocks,
 * each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].
 */
public class Lesson10 {


    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        System.out.println(solution2(array));

    }

    public static int solution(int[] array){
        // edge cases
        if(array.length <= 2) return 0;

        // count how many peaks
        int[] peaks = new int[array.length];
        int peakIndex = 0;
        for(int i = 1; i < array.length-1; ++i){
            if(array[i]>array[i-1] && array[i]>array[i+1]){
                peaks[peakIndex] = i;
                ++peakIndex;
            }
        }

        // edge cases
        if(peakIndex <=2) return peakIndex;

        // count how many combination of peaks
        int maxFlag = (int) (Math.sqrt(peaks[peakIndex-1] - peaks[0]) + 1);

        for(int i = maxFlag; i >= 2; --i){
            int count = 1;
            int currPos = peaks[0];
            for(int j = 1; j < peaks.length; ++j){
                if( currPos + i <= peaks[j]){
                    currPos = peaks[j];
                    ++count;
                }
            }
            if(count >= i) return i;
        }
        return 2;
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 2) return 0;
        int[] peaks = new int[A.length];
        int size = 0;
        for (int i = 1; i < A.length-1; ++i) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks[size] = i;
                ++size;
            }
        }

        if (size <=2) return size;

        int maxFlag = (int)Math.sqrt(peaks[size-1] - peaks[0]) + 1;

        for (int i = maxFlag; i >= 2; --i) {
            int count = 1;
            int curPos = peaks[0];
            for (int j = 1; j < size; ++j) {
                if (curPos + i <= peaks[j]) {
                    curPos = peaks[j];
                    ++count;
                }
            }
            if (count >= i) return i;
        }

        return 2;
    }

}
