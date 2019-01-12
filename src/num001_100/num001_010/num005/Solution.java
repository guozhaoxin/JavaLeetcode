package num001_100.num001_010.num005;

/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
**/

public class Solution {
    private String res;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        for(int i = 0;i < s.length();i++){
            this.midExpan(s,i,i);
            if ((i + (res.length() - 1) / 2) >= s.length()){
                break;
            }
            this.midExpan(s,i,i + 1);
            if ((i + 1 + res.length() / 2) >= s.length()){
                break;
            }
        }
        return res;
    }
    private void midExpan(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(res == null || (right - left) > res.length()){
            res = s.substring(left + 1,right);
        }
    }
}