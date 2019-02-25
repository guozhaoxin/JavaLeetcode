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
        StringBuilder hah = new StringBuilder();
        hah.append("a");
        hah.append("b");
        hah.reverse();
        System.out.println(hah);
    }

}

class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        res.reverse();
        int mul,temp;
        for(int out = num1.length() - 1;out >= 0;out--){
            int carry = 0;
            for(int in = num1.length() - 1;in >= 0;in--){
                temp = (num1.charAt(out) - '0') * (num2.charAt(in) - '0') + carry;

            }
        }
        return res.toString();
    }
}
