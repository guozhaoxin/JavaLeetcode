package num001_100.num031_040.num039;

/*
39. Combination Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num039 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3};
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum(nums,1);
        System.out.println(res);
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for(int index = candidates.length - 1;index >= 0;index--){
            if(candidates[index] > target){
                continue;
            }
            List<Integer> cur = new ArrayList<>();
            cur.add(candidates[index]);
            this.helper(candidates,index,target - candidates[index],cur,res);
        }
        return res;
    }

    private void helper(int[] candidates, int index, int remainder, List<Integer> cur, List<List<Integer>> res){
//        System.out.println(cur);
        if(remainder < 0){
            return;
        }
        if(remainder == 0){
            List<Integer> temp = new ArrayList<>();
            for(Integer num : cur){
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        for(int i = index;i >= 0;i--){
            cur.add(candidates[i]);
            this.helper(candidates,i,remainder - candidates[i],cur,res);
            cur.remove(cur.size() - 1);
        }
    }
}