package net.famunity.trial.java.travelport;


public class Solution3 {

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {5,4,4},
                {4,3,4},
                {3,2,4},
                {2,2,2},
                {3,3,4},
                {1,4,4},
                {4,1,1}
        };

        System.out.println(solution(A));
    }

    public static int solution(int[][] A) {
        // write your code in Java SE 8
        int rowSize = A.length;
        int columnSize = A[0].length;

        // A[0][0] as 1st country all times;
        int countries = 0;

        int current;
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < columnSize; j++){
                int above=-1, left=-1;

                current = A[i][j];
                if(i>=1) {
                    above = A[i-1][j];
                }
                if(j>=1){
                    left = A[i][j-1];
                }

                if(current != above && current != left) {
                    countries++;
                } else if(current == left && above == left){
                    countries--;
                }
            }
        }

        return countries;
    }




}
