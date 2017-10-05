package net.famunity.trial.java.algorithm;

public class _0004_UniqueNumberFromArray {
    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 5, 7, 9, 7, 9, 3, 1};

        System.out.println("Unique number is " + uniqueNumber(array));

    }

    private static int uniqueNumber(int[] array) {
        int ans = 0;
        for (int i = 0; i < array.length; i++){
            ans ^= array[i];
        }
        return ans;
    }

}
