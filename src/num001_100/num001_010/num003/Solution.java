package num001_100.num001_010.num003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/


//public class Solution {
//    public  int getNoRepeatedMaxLen(String str){
//        int max = 0;
//
//        if(str.length() <= 1){
//            return str.length();
//        }
//
//        int left = 0;
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        for(int i = 0; i < str.length(); i++){
//            Character tmp = str.charAt(i);
//            if(map.containsKey(tmp)){
//                left = map.get(tmp) + 1;
//            }
//            max = Math.max(max, i - left + 1);
//            map.put(tmp, i);
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int a = s.getNoRepeatedMaxLen("abcabcbb");
//        System.out.println(a);
//    }
//}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, res = 0;
        while(end < s.length()) {
            while(!set.add(s.charAt(end))) set.remove(s.charAt(start++));
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);
    }
}