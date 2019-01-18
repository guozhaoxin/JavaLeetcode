package num001_100.num011_020.num015;

/*
15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class num015 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                -1, 0, 1, 2, -1, -4
        };
        nums = new int[]{
                0,0,0,0
        };
        Solution s = new Solution();
        List<List<Integer>> res = s.threeSum(nums);
        System.out.println(res);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> numcount = new HashMap<Integer, Integer>();
        for(int index = 0;index < nums.length;index++){
            if(!numcount.containsKey(nums[index])){
                numcount.put(nums[index],0);
            }
            numcount.put(nums[index],numcount.get(nums[index]) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(numcount.containsKey(0)){
            if(numcount.get(0) >= 3){
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(0);
                cur.add(0);
                cur.add(0);
                res.add(cur);
            }
            numcount.put(0,1);
        }
        for(int key:numcount.keySet()){
            if(numcount.get(key) >= 2){
                if(numcount.containsKey((-key -key))){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    temp.add(key);
                    temp.add(-key-key);
                    res.add(temp);
                }
            }
            for(int j : numcount.keySet()){
                if(j <= key){
                    continue;
                }
                int middle = 0 - key - j;
                if (middle >= j || middle <= key){
                    continue;
                }
                if(numcount.containsKey(middle)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    temp.add(j);
                    temp.add(-key-j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}