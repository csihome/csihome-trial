package net.famunity.trial.java.travelport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {

        int A = 99999999;
        int B = 1;
        int C = 0;
        int D = 100000000;
        int E = 100000000;

        int result = solution(D, E);

        System.out.println(result);
    }

    private static int solution(int a, int b) {
        StringBuilder result = new StringBuilder();

        List<Character> listA = convertIntToList(a);
        List<Character> listB = convertIntToList(b);

        Iterator itA = listA.iterator();
        Iterator itB = listB.iterator();
        while(itA.hasNext() || itB.hasNext()){
            if(itA.hasNext())
                result.append(itA.next());
            if(itB.hasNext())
                result.append(itB.next());
        }

        System.out.println(result);
        Integer resultInt = Integer.parseInt(result.toString());
        if(resultInt > 100000000)
            return -1;
        return resultInt;
    }

    public static List<Character> convertIntToList(int i) {
        String I = i + "";
        List<Character> listI = new ArrayList<>();
        for(int j = 0; j < I.length(); j++){
            listI.add(I.charAt(j));
        }
        return listI;
    }

}
