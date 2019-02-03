package num001_100.num021_030.num028;

/*
28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

public class num028 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello","ll"));
        System.out.println(s.strStr("aaaaa","bba"));
        System.out.println(s.strStr("",""));
        System.out.println(s.strStr("a",""));
        System.out.println(s.strStr("aaa","aa"));
        System.out.println(s.strStr("abc","bcd"));
        System.out.println((-7) / (-3));
    }
}


class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i = 0;i < haystack.length();i++){
            if(haystack.length() - i < needle.length()){
                break;
            }
            int j = 0;
            for(;j < needle.length();j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}