package num001_100.num001_010.num001;

import java.util.HashMap;

/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class num001 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.twoSum(null,100);
        int[] nums = {2, 7, 11, 15};
        int[] res = s.twoSum(nums,9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null){
            return res;
        }
        HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
        for(int index = 0;index < nums.length;index++){
            if(temp.containsKey(target - nums[index])){
                res[0] = index;
                res[1] = temp.get(target - nums[index]);
                break;
            }
            temp.put(nums[index],index);
        }
        return res;
    }
}