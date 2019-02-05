package num001_100.num031_040.num032;

/*
32. Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */

import java.util.ArrayList;
import java.util.Stack;


public class num032 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses("()()"));
        System.out.println(s.longestValidParentheses(")()())"));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }
        int longest = 0,start = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int index = 0;index < s.length();index++){
            if(s.charAt(index) == '('){
                stack.push(index);
            }else if(stack.size() == 1){
                stack.pop();
                stack.push(index);
            }else {
                stack.pop();
                longest = Math.max(longest,index - stack.get(stack.size() - 1));
            }
        }
        return longest;
    }
}