package num001_100.num001_010.num008;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */

public class num008 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("ad12345678"));
        System.out.println(s.myAtoi("    +1234567890a"));
        System.out.println(s.myAtoi("1234567890000"));
        System.out.println(s.myAtoi("-1234567890000"));
        System.out.println(s.myAtoi("-91283472332"));
        System.out.println(s.myAtoi("-0083472332"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi("0-1"));
    }
}

class Solution {
    public int myAtoi(String str) {
        int index = 0;
        while (index < str.length()){
            if(str.charAt(index) != ' '){
                break;
            }
            index += 1;
        }
        if(index == str.length()){
            return 0;
        }

        if(((str.charAt(index) > '9') || (str.charAt(index) < '0')) && (str.charAt(index) != '-') && (str.charAt(index) != '+')){
            return 0;
        }
        int flag = 1;
        if(str.charAt(index) == '-'){
            flag = -1;
            index += 1;
        }
        else if(str.charAt(index) == '+'){
            index += 1;
        }
        if(index == str.length()){
            return 0;
        }

        while (index < str.length() && str.charAt(index) == '0'){
            index++;
        }
        if(index == str.length()){
            return 0;
        }
        while (index < str.length() && str.charAt(index) == '0'){
            index++;
        }
        if(index == str.length()){
            return 0;
        }

        int res = 0;
        while (index < str.length()) {
            if(str.charAt(index) > '9' || str.charAt(index) < '0'){
                break;
            }
            if(flag == 1){
                if(res > 214748364){
                    return Integer.MAX_VALUE;
                }
                else if(res == 214748364 && str.charAt(index) > '7'){
                    return Integer.MAX_VALUE;
                }
            }
            if(flag == -1){
                if(res < -214748364){
                    return Integer.MIN_VALUE;
                }
                else if(res == -214748364 && str.charAt(index) > '8'){
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + flag *(str.charAt(index) - '0');
            index++;
        }
        return res;
    }
}