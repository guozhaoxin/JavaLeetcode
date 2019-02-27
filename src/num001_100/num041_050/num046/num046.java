package num001_100.num041_050.num046;

/*
46. Permutations/

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;
import java.util.List;

public class num046 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.permute(new int[]{1,2,3});
        System.out.println(res);
        System.out.println(res.size());
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        this.helper(nums,0,nums.length - 1,res);
        return res;
    }

    private void helper(int[] nums, int l, int r, List<List<Integer>> list) {

        if (l == r) {
            List<Integer> lst = new ArrayList<>();
            for (int n : nums) {
                lst.add(n);
            }
            list.add(lst);
        }else {

            for (int i = l; i <= r; i++) {
                swap(nums, l, i);
                helper(nums, l + 1, r, list);
                swap(nums, l, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}