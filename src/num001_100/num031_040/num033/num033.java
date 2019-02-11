package num001_100.num031_040.num033;

public class num033 {
    public static void main(String[] args) {
    int[] nums = new int[]{4,5,6,7,0,1,2};
    Solution s = new Solution();
    System.out.println(s.search(nums,1));
    System.out.println(s.search(nums,-1));
    nums = new int[]{5,1,2,3,4};
    System.out.println(s.search(nums,1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<nums[end]){
                if(nums[mid]<target&&target<=nums[end])
                    start=mid+1;
                else end=mid-1;
            }else{
                if(nums[start]<=target&&target<nums[mid])
                    end=mid-1;
                else start=mid+1;
            }
        }
        return -1;
    }
}