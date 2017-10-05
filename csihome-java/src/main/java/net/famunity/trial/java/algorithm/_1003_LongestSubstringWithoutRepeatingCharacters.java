package net.famunity.trial.java.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcdbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _1003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcdbb";
        System.out.println(lengthOfLongestSubstringSet(s));
        System.out.println(lengthOfLongestSubstringMap(s));
    }

    public static int lengthOfLongestSubstringSet(String s){
        int n = s.length();
        Set<Character> nonrepeatableChars = new HashSet<>();
        int result=0, left=0, right=0;
        while (left < n && right < n) {
            char expending = s.charAt(right++);
            if(!nonrepeatableChars.contains(expending)) {
                nonrepeatableChars.add(expending);
                result = Math.max(result, right-left);
            } else {
                nonrepeatableChars.remove(left);
                left++;
            }
        }

        return result;
    }

    public static int lengthOfLongestSubstringMap(String s){
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right =0; right < n; right++) {
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)), left);
            }
            result = Math.max(result, right-left+1);
            map.put(s.charAt(right),right+1);
        }

        return result;
    }
}
