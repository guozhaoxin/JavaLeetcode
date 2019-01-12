package num001_100.num001_010.num006;

/*
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
                             PAHNAPLSIIGYIR

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
         PINALSIGYAHRPI
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
**/

public class num006 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING",3));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s == null){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for(int index = 0;index < numRows;index++){
            res[index] = new StringBuilder();
        }
        int resIndex = 0,step = 1;
        for(int index = 0;index < s.length();index++){
            res[resIndex].append(s.charAt(index));
            if(step == 1){
                if(resIndex == numRows - 1){
                    step = -1;
                }
            }else {
                if(resIndex == 0){
                    step = 1;
                }
            }
            resIndex += step;
        }
        s = "";
        for(int index = 0;index < res.length;index++){
            s += res[index];
        }
        return s;
    }
}

class Solution1 {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}