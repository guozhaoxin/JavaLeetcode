package num001_100.num041_050.num043;

/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class num043 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("123","456"));
        System.out.println(s.multiply("7","12"));
        System.out.println(s.multiply("7","6"));
        System.out.println(s.multiply("7","7"));
        System.out.println(s.multiply("7","1"));
        System.out.println(s.multiply("1","7"));
        System.out.println(s.multiply("1","1"));
        System.out.println(s.multiply("0","123"));
        System.out.println(s.multiply("1234","0"));
    }

}

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if(num1.equals("1")){
            return num2;
        }
        if(num2.equals("1")){
            return num1;
        }
        int lengthen = num1.length() + num2.length();
        StringBuilder res = new StringBuilder(lengthen);
        for(int i = 0; i < lengthen;i++){
            res.append('0');
        }
        int resBit = 0;
        for(int n1_index = num1.length() - 1;n1_index >= 0;n1_index--){
            int temp,carry = 0,cur = resBit;
            for(int n2_index = num2.length() - 1;n2_index >= 0;n2_index--,cur++){
                temp = (num1.charAt(n1_index) - '0') * (num2.charAt(n2_index) - '0') + carry + res.charAt(cur) - '0';
                carry = temp / 10;
                res.setCharAt(cur,(char)('0' + temp % 10));
            }
            if(carry != 0) {
                res.setCharAt(cur, (char) (carry + res.charAt(cur)));
            }
            resBit++;
        }
        while (res.charAt(res.length() - 1) == '0'){
            res.deleteCharAt(res.length() - 1);
        }
        return res.reverse().toString();
    }
}
