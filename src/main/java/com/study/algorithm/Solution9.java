package com.study.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @Author: zhangqian
 * @Date: 2022/8/30
 * @Description:
 */
public class Solution9 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //1.0 --转了字串
   /* public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x<10){
            return true;
        }
        StringBuilder sb=new StringBuilder();
        String s=String.valueOf(x);
        while(x>0){
            int a=x%10;
            sb.append(a);
            x=x/10;
        }
        if(sb.toString().equals(s)){
           return true;
        }
        return false;
    }*/
    //2.0
/*    public boolean isPalindrome(int x) {
        //负数不可能是回文数 ,末尾数不能为0，如果为0则首位必须为0，
        if(x<0||x%10==0){
            return false;
        }else if(x<10){
            return true;
        }
        int res=0,emp=x;
        while(emp>0){
            int a=emp%10;
            res=res*10+a;
            emp=emp/10;
        }
        return res==x;
    }*/
    //3.0 官方
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
    @Test
    public void test(){
        System.out.println(this.isPalindrome(121));
    }
}
