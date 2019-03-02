package num001_100.num041_050.num048;

/*
48. Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/

public class num048 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        Solution s = new Solution();
        s.rotate(nums);
        for(int[] row : nums){
            for(int num : row){
                System.out.print(num);
                System.out.print('\t');
            }
            System.out.println();
        }
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        for(int row = 0;row < matrix.length;row++){
            for(int col = 0;col < matrix.length - 1 - row;col++){
                this.swap(matrix,row,col,matrix.length - 1 - col,matrix.length - 1 - row);
            }
        }

        int middle = matrix.length / 2;
        for(int row = 0;row < middle;row++){
            for(int col = 0;col < matrix.length;col++){
                this.swap(matrix,row,col,matrix.length - 1 - row,col);
            }
        }
    }

    private void swap(int[][] matrix,int row1,int col1,int row2,int col2){
        int temp;
        temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}