package num001_100.num031_040.num031;


/*
31. Next Permutation/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

public class num031 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3};
        s.nextPermutation(nums);
        num031.print(nums);
    }
    public static void print(int[] nums){
        for(int num : nums){
            System.out.print(num);
        }
        System.out.println();
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1){
            return;
        }
        int i = nums.length - 1,j;
        while (i > 0){
            if(nums[i] > nums[i - 1]){
                break;
            }
            i--;
        }
        if(i == 0){
            this.swap(0,nums.length - 1,nums);
        }else {
            j = i;
            while (j < nums.length && nums[j] > nums[i - 1]){
                j++;
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[j - 1];
            nums[j - 1] = temp;
            this.swap(i,nums.length - 1,nums);
        }
    }

    private void swap(int start,int end,int[] nums){
        int temp;
        while (start <= end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}