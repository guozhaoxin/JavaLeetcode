package num001_100.num031_040.num037;

/*
37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */

import java.util.HashSet;

public class num037 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Solution s = new Solution();
        s.solveSudoku(board);
        num037.print(board);
    }
    public static void  print(char[][] board){
        for(char[] line: board){
            for(char ch : line){
                System.out.print(ch);
                System.out.print('\t');
            }
            System.out.println();
        }
    }
}

class Solution {
    public void solveSudoku(char[][] board) {
        this.dfs(board,0,0);
    }
    private boolean dfs(char[][] board,int row,int col){
        if(row == 9){
            return true;
        }
        if(col == 9){
            return this.dfs(board,row + 1,0);
        }
        if(board[row][col] == '.'){
            HashSet<Character> hashSet = this.check(board,row,col);
            for(char c : hashSet){
                board[row][col] = c;
                boolean res = this.dfs(board,row,col + 1);
                if(!res){
                    board[row][col] = '.';
                }else {
                    return true;
                }
            }
            return false;
        }else {
            return this.dfs(board,row,col + 1);
        }
    }

    private HashSet<Character> check(char[][] board,int row,int col){
        HashSet<Character> hashSet = new HashSet<>();
        for(int num = 1;num < 10;num++){
            hashSet.add((char)(num + '0'));
        }
        for(int index = 0;index < 9;index++){
                hashSet.remove(board[row][index]);

        }
        for(int index = 0;index < 9;index++){
                hashSet.remove(board[index][col]);
        }

        int rowbase = row / 3 * 3;
        int colbase = col / 3 * 3;
        for(int i = 0;i < 3;i++){
            int curRow = rowbase + i;
            for(int j = 0;j < 3;j++){
                int curCol = colbase + j;
                    hashSet.remove(board[curRow][curCol]);
            }
        }
        return hashSet;
    }
}
