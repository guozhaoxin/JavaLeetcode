package num001_100.num001_010.num009;

public class num009 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(-123));
        System.out.println(s.isPalindrome(0));
        System.out.println(s.isPalindrome(1234));
        System.out.println(s.isPalindrome(12321));
        System.out.println(s.isPalindrome(123321));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }

        int reverNum = 0,temp = x;
        int last;
        while (x > 0){
            last = x % 10;
            x /= 10;
            reverNum = reverNum * 10 + last;
        }
        if(temp == reverNum){
            return true;
        }

        return false;
    }
}