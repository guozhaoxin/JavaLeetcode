package num001_100.num001_010.num007;


/*
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
* */
public class num007 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-1234));
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(2147483647));
    }
}

class Solution {

    private long flag1 = 2147483648L;
    private long flag2 = -2147483648L;
    public int reverse(int x) {

        if(x == -2147483648){
            return 0;
        }

        int flag = 1;
        if(x < 0 ){
            flag = -1;
        }
        x = Math.abs(x);
        StringBuilder xsb = new StringBuilder();
        xsb.append(x);

        int middle = xsb.length() / 2;
        char temp;
        for(int i = 0;i < middle;i++ ){
            temp = xsb.charAt(i);
            xsb.setCharAt(i,xsb.charAt(xsb.length() - i - 1));
            xsb.setCharAt(xsb.length() - i - 1,temp);
        }

        long res = Long.valueOf(xsb.toString());
        if(res >= flag1){
            return 0;
        }
        res *= flag;
        if(res <= flag2){
            return 0;
        }
        return (int)res;
//        return 0;
    }
}

class Solution1 {
    public int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }
}