package num001_100.num011_020.num_014;

/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class num014 {
    public static void main(String[] args) {
        String[] strs = new String[]{
                "flower","flow","flight"
        };
        strs = new String[]{
                "郭兆鑫","郭兆金",
        };
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(strs));
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0] == null || strs[0].length() == 0){
            return "";
        }
        int longest = 0;
        for(int index = 1;index <= strs[0].length();index++){
            String temp = strs[0].substring(0,index);
            int j;
            for (j = 1;j < strs.length;j++){
                if(!strs[j].startsWith(temp)){
                    break;
                }
            }
            if(j != strs.length){
                break;
            }
            longest = index;
        }
        return strs[0].substring(0,longest);
    }
}