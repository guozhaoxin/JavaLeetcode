package num001_100.num011_020.num018;

/*
18. 4Sum
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num018 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{1, 0, -1, 0, -2, 2};
//        array = new int[]{0,0,0,0};
        List<List<Integer>> res = s.fourSum(array,0);
        System.out.println(res);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int start = 0;start < nums.length - 3;start++){
            if(nums[start] + nums[start+1] + nums[start + 2] + nums[start + 3] > target){
                break;
            }
            if(nums[start] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target){
                continue;
            }
            if((start > 0) && nums[start] == nums[start - 1]){
                continue;
            }
            for(int middle = start + 1;middle < nums.length - 2;middle++){
                if(nums[start] + nums[middle] + nums[middle + 1] + nums[middle + 2] > target){
                    break;
                }
                if(nums[start] + nums[middle] + nums[nums.length - 1] + nums[nums.length - 2] < target){
                    continue;
                }
                if((middle > start + 1) && nums[middle] == nums[middle - 1]){
                    continue;
                }
                int left = middle + 1,right = nums.length - 1;
                while (left < right){
                    if((left > middle + 2) && nums[left] == nums[left - 1]){
                        left++;
                        continue;
                    }
                    if((right < nums.length - 1)&& nums[right] == nums[right + 1]){
                        right--;
                        continue;
                    }

                    int temp = nums[start] + nums[middle] + nums[left] + nums[right];
                    if(temp == target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[start]);
                        cur.add(nums[middle]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        left++;
                        right--;
                    }else if(temp < target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}