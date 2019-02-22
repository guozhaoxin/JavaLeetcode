package num001_100.num031_040.num040;

/*
40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num040 {
    public static void main(String[] args) {
        int[] candiates = new int[]{10,1,2,7,6,1,5};
//        candiates = new int[]{2,5,2,1,2};
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum2(candiates,8);
        System.out.println(res);
    }
}


class Solution {
     List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        Arrays.sort(candidates);
        if(candidates[0] > target){
            return res;
        }
        this.helper(candidates,target,0,res,new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates,int remainder,int index,List<List<Integer>> res,ArrayList<Integer> cur){
        if(remainder < 0){
            return;
        }
        if(remainder == 0){
            List<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        }

        for(int i = index;i < candidates.length;i++){
            if(i == index){
                cur.add(candidates[i]);
                this.helper(candidates,remainder - candidates[i],i + 1,res,cur);
                cur.remove(cur.size() - 1);
            }else {
                if(candidates[i] == candidates[i - 1]){
                    continue;
                }
                if(remainder < candidates[i]){
                    break;
                }
                cur.add(candidates[i]);
                this.helper(candidates,remainder - candidates[i],i + 1,res,cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}