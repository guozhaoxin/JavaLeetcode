package num001_100.num041_050.num041;


/*
41. First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
 */

import java.util.Arrays;
import java.util.HashMap;

public class num041 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = new int[]{3,4,-1,1,100};
        nums = new int[]{1,2,2,3,4};
        System.out.println(s.firstMissingPositive(nums));
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int first = 1;
        HashMap<Integer,Boolean> posFlagMap = new HashMap<>();
        for(int num : nums){
            if(num > 0){
                posFlagMap.put(num, true);
                if(first == num){
                    while (posFlagMap.containsKey(first)){
                        first++;
                    }
                }
            }
        }
        return first;
    }
}

class Solution1 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length
                    && nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                System.out.println(Arrays.toString(nums));
                //System.out.println(i+ "  " +Arrays.toString(nums));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }

        return nums.length+1;
    }

    public void swap(int[] nums, int i, int j) {
        int tep = nums[i];
        nums[i] = nums[j];
        nums[j] = tep;
    }
}