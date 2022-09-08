package com.study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangqian
 * @Date: 2022/9/2
 * @Description:
 */
public class Solution13 {
    /**
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //1.0
    /*public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        {
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
        }
        Integer number=0;
        if(s==null||"".equals(s)){
            return number;
        }
        int before=0;//前一位数据

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int now=map.get(c);
            //如果前一位小于当前位，说明需要减
            if(before!=0&&now>before){
                number=number+now-2*before;
            }else{
                number+=now;
            }
            before=now;
        }
        return number;
    }*/
    //2.0 map 换成Switch  某些条件下，Switch的消耗逼map的消耗小
    public int romanToInt(String s) {
        Integer number=0;
        if(s==null||"".equals(s)){
            return number;
        }
        int before=0;//前一位数据

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int now=getValue(c);
            //如果前一位小于当前位，说明需要减
            if(before!=0&&now>before){
                number=number+now-2*before;
            }else{
                number+=now;
            }
            before=now;
        }
        return number;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    @Test
    public void test(){
        int mcmxciv = this.romanToInt("MCMXCIV");
        System.out.println(mcmxciv);
    }
}
