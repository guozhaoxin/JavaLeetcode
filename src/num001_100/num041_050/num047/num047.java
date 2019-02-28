package num001_100.num041_050.num047;

/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]



 */

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class num047 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,1,1,2,2,3,3};
//        nums = new int[]{-1,2,0,-1,1,0,1};
        Solution s = new Solution();
        List<List<Integer>> res = s.permuteUnique(nums);
        System.out.println(res);
        System.out.println(res.size());
        for(int i = 0;i < res.size();i++){
            List<Integer> cur = res.get(i);
            boolean comp = true;
            for(int j = i + 1;j < res.size();j++){
                List<Integer> ano = res.get(j);
                for(int index = 0;index < cur.size();index++){
                    if(cur.get(index) != ano.get(index)){
                        comp = false;
                        break;
                    }
                }
                if(comp){
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(cur);
                    System.out.println(ano);
                }
            }

        }
    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
//        Arrays.sort(nums);
        this.dfs(nums,0,res);
        return res;
    }

    private void dfs(int[] nums,int left,List<List<Integer>> res){
        if(left == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        Set<Integer> haseSet = new HashSet<>();

        for(int index = left;index < nums.length;index++){
            if(!haseSet.contains(nums[index])){
                haseSet.add(nums[index]);
                this.swap(nums,left,index);
                this.dfs(nums,left + 1,res);
                this.swap(nums,left,index);
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}