package num001_100.num031_040.num036;

/*
36. Valid Sudoku
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */

import java.util.HashSet;

public class num036 {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
//        if(board == null || board.length != 9 || board[0] == null || board[0].length != 9){
//            return false;
//        }
        for(int row = 0;row < 9;row++){
            if(!this.isValidRow(board,row)){
                return false;
            }
        }
        for(int col = 0;col < 9;col++){
            if(!this.isValidCol(board,col)){
                return false;
            }
        }
        for(int row = 0;row < 9;row += 3){
            for(int col = 0;col < 9;col += 3){
                if(!this.isValidSquare(board,row,col)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board,int row){
        HashSet<Character> hashSet = new HashSet<>();
        for(int index = 0;index < 9;index++){
            if(board[row][index] == '.'){
                continue;
            }
//            if(board[row][index] > '9' || board[row][index] < '0'){
//                return false;
//            }
            if(hashSet.contains(board[row][index])){
                return false;
            }
            hashSet.add(board[row][index]);
        }
        return true;
    }

    private boolean isValidCol(char[][] board,int col){
        HashSet<Character> hashSet = new HashSet<>();
        for(int index = 0;index < 9;index++){
            if(board[index][col] == '.'){
                continue;
            }
//            if(board[index][col] < '0' || board[index][col] > '9'){
//                return false;
//            }
            if(hashSet.contains(board[index][col])){
                return false;
            }
            hashSet.add(board[index][col]);
        }
        return true;
    }

    private boolean isValidSquare(char[][] board,int row,int col){
        HashSet<Character> hashSet = new HashSet<>();
        for(int rowIndex = row;rowIndex < row + 3;rowIndex++){
            for(int colIndex = col;colIndex < col + 3;colIndex++){
                if(board[rowIndex][colIndex] == '.'){
                    continue;
                }
//                if(board[rowIndex][colIndex] > '9' || board[rowIndex][colIndex] < '0'){
//                    return false;
//                }
                if(hashSet.contains(board[rowIndex][colIndex])){
                    return false;
                }
                hashSet.add(board[rowIndex][colIndex]);
            }
        }
        return true;
    }
}