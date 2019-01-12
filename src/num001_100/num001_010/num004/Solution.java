package num001_100.num001_010.num004;

/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len2 == 0){
            if(len1 % 2 == 0){
                return (nums1[len1/2] + nums1[len1/2 - 1])/2.0;
            }
            else {
                return nums1[len1/2];
            }
        }

        if(len1 == 0){
            if(len2 % 2 == 0){
                return (nums2[len2/2] + nums2[len2/2 - 1])/2.0;
            }
            else {
                return nums2[len2/2];
            }
        }

        int index1 = 0,index2 = 0;
        int[] temp = new int[len1 + len2];
        int index = 0;
        while (index1 < len1 && index2 < len2){
            if(nums1[index1] < nums2[index2]){
                temp[index++] = nums1[index1++];
            }
            else {
                temp[index++] = nums2[index2++];
            }
        }
        if(index1 < len1){
            while (index1 < len1){
                temp[index++] = nums1[index1++];
            }
        }
        if(index2 < len2){
            while (index2 < len2){
                temp[index++] = nums2[index2++];
            }
        }
        if((len1 + len2) % 2 == 0){
            int mid = (len1 + len2 - 1) / 2;
            return (temp[mid] + temp[mid + 1])/2.0;
        }
        else {
            return temp[(len1 + len2) / 2];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }
}