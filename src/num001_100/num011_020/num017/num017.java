package num001_100.num011_020.num017;

/*
/=17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num017 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations(""));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null){
            return null;
        }
        ArrayList<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        HashMap<Character,ArrayList<Character>> map = new HashMap<>();
        ArrayList<Character> temp = new ArrayList<>();
        temp.add('a');
        temp.add('b');
        temp.add('c');
        map.put('2',temp);
        temp = new ArrayList<>();
        temp.add('d');
        temp.add('e');
        temp.add('f');
        map.put('3',temp);

        temp = new ArrayList<>();
        temp.add('g');
        temp.add('h');
        temp.add('i');
        map.put('4',temp);

        temp = new ArrayList<>();
        temp.add('j');
        temp.add('k');
        temp.add('l');
        map.put('5',temp);

        temp = new ArrayList<>();
        temp.add('m');
        temp.add('n');
        temp.add('o');
        map.put('6',temp);

        temp = new ArrayList<>();
        temp.add('p');
        temp.add('q');
        temp.add('r');
        temp.add('s');
        map.put('7',temp);

        temp = new ArrayList<>();
        temp.add('t');
        temp.add('u');
        temp.add('v');
        map.put('8',temp);

        temp = new ArrayList<>();
        temp.add('w');
        temp.add('x');
        temp.add('y');
        temp.add('z');
        map.put('9',temp);

        return this.dfs(digits,0,map);
    }

    private ArrayList<String> dfs(String s,int index,HashMap<Character,ArrayList<Character>> map){

        if(index == s.length() - 1){
            ArrayList<String> cur = new ArrayList<>();
            for(Character c : map.get(s.charAt(index))){
                cur.add(c.toString());
            }
            return cur;
        }else {
            ArrayList<String> tail = this.dfs(s,index + 1,map);
            ArrayList<String> res = new ArrayList<>();
            for(Character c : map.get(s.charAt(index))){
                for(String string : tail){
                    res.add(c.toString() + string);
                }
            }
            return res;
        }
    }
}