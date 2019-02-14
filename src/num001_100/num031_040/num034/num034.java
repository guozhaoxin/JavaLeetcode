package num001_100.num031_040.num034;

/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

public class num034 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] res = s.searchRange(nums,8);
        System.out.println(res[0]);
        System.out.println(res[1]);
        nums = new int[]{5,7,7,8,8,10};
        res = s.searchRange(nums,6);
        System.out.println(res[0]);
        System.out.println(res[1]);

        nums = new int[]{5,7,7,7,8,10};
        res = s.searchRange(nums,8);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target){
            return res;
        }

        int left = 0,right = nums.length - 1,middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(nums[middle] == target){
                int temp;
                temp = this.helper(nums,target,0,middle,-1);
                res[0] = temp;
                temp = this.helper(nums,target,middle,nums.length - 1,1);
                res[1] = temp;
                break;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }

        return res;
    }

    private int helper(int[] nums,int target,int left,int right,int direction){
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(direction == 1){
                if(nums[middle] == target){
                    if(middle == nums.length - 1 || nums[middle + 1] > target){
                        return middle;
                    }
                    left = middle + 1;
                }else {
                    right = middle - 1;
                }
            }else {
                if(nums[middle] == target){
                    if(middle == 0 || nums[middle] < target){
                        return middle;
                    }
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }
            }
        }
        if(direction == 1){
            return right;
        }else {
            return left;
        }
    }
}