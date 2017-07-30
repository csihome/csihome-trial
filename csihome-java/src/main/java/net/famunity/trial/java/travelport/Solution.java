package net.famunity.trial.java.travelport;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] A = new int[]{3, 4, 5, 8, 10, 12, 5, 1, 5};

        int result = solution(A);

        System.out.println(result);
    }

    static int solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }

    static int solution2(int[] A) {

        int result = 0, N = A.length;

        Map<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < N; i++) {
            hashMap.put(A[i], i);
        }

        for (int i = 0; i < N; i++) {
            if(hashMap.containsKey(A[i]) && i!=hashMap.get(A[i])){
                result = Math.max(result, Math.abs(i-hashMap.get(A[i])));
            }
        }

        return result;
    }
}
