package num001_100.num011_020.num016;

import java.util.Arrays;

/*
16. 3Sum Closest
Given an array nums of n integers and an integer target, find three integers in nums such that
the sum is closest to target. Return the sum of the three integers. You may assume that each input
would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class num016 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-1,-1,3};
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(nums,3));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        int abs = Math.abs(target - res);
        for(int index = 0;index < nums.length - 2;index++){
            int left = index + 1,right = nums.length - 1;
            int temp,cur_abs;
            while (left < right){
                temp = nums[index] + nums[left] + nums[right];
                if(temp == target){
                    return target;
                }
                cur_abs = Math.abs(temp - target);
                if(cur_abs < abs ){
                    abs = cur_abs;
                    res = temp;
                }
                if(temp > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }
}