package num001_100.num021_030.num029;

/*
29. Divide Two Integers
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class num029 {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.divide(0,1));
        System.out.println(s.divide(7,-3));
        System.out.println(s.divide(-2147483648,-1));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == Integer.MIN_VALUE) {
            if(dividend == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if(dividend == 0){
            return 0;
        }
        boolean positive = !((dividend > 0)^(divisor > 0));
        long remain;
        if(dividend == Integer.MIN_VALUE){
            remain = 2147483648L;
        }
        else {
            remain = Math.abs(dividend);
        }
        divisor = Math.abs(divisor);
        long pos = 1,base = divisor;
        while (base <= remain){
            base <<= 1;
            pos <<= 1;
        }
        long res = 0;
        while (pos > 0){
            if(base <= remain){
                remain -= base;
                res += pos;
            }
            pos >>= 1;
            base >>= 1;
        }
        if(res == 2147483648L){
            if(positive){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        if(!positive){
            res = -res;
        }
        return (int)res;
    }
}