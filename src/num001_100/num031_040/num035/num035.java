package num001_100.num031_040.num035;

/*
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

public class num035 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(s.searchInsert(nums,2));
        System.out.println(s.searchInsert(nums,7));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {

        if(nums.length == 0){
            return 0;
        }
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }

        int left = 0,right = nums.length - 1,middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }
}