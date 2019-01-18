package num001_100.num011_020.num011;


/*
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
public class num011 {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        Solution s = new Solution();
        System.out.println(s.maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0,right = height.length - 1;
        int curArea;
        while (left < right){
            curArea = (right - left) * Math.min(height[right],height[left]);
            res = Math.max(curArea,res);
            if(height[left] < height[right]){
                left++;
            }
            else if(height[left] > height[right]){
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        return res;
    }
}