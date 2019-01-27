package num001_100.num011_020.num020;


import java.util.ArrayList;
import java.util.HashMap;

/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class num020 {
    public static void main(String[] args) {
        String s = "()";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }
}


class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }

        ArrayList<Character> stack = new ArrayList<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int index = 0;index < s.length();index++){
            if(!map.containsKey(s.charAt(index))){
                stack.add(s.charAt(index));
            }else {
                if(stack.size() == 0){
                    return false;
                }else if(stack.get(stack.size() - 1) != map.get(s.charAt(index))){
                    return false;
                }else {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        if(stack.size() != 0){
            return false;
        }
        return true;
    }
}