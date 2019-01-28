package num001_100.num021_030.num022;


import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class num022 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.generateParenthesis(4);
        if(res == null){
            System.out.println("empty res");
        }else {
            System.out.println(res);
            System.out.println(res.size());
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        this.dfs(res,n,0,0,new StringBuilder());
        return res;
    }

    private void dfs(List<String> res,int n,int left,int right,StringBuilder sb){
        if(left == n && right == n){
            res.add(sb.toString());
        }else {
            if(left < n){
                sb.append('(');
                this.dfs(res,n,left + 1,right,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(right < left){
                sb.append(')');
                this.dfs(res,n,left,right + 1,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}