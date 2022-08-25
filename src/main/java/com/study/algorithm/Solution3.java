package com.study.algorithm;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * @Author: zhangqian
 * @Date: 2022/8/19
 * @Description:
 */
public class Solution3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param str
     * @return
     */
    //1.0
    /*public int lengthOfLongestSubstring(String s) {
        //如果s为空，length不大于0，是一个空串，就没有向下执行的必要了
        if(s != null && s.length() > 0 && s != ""){
            //String -> char[]
            char[] strChar = s.toCharArray();
            // 存储最长字串 key:char值，value:index下标
            ArrayList<String> maxStr = new ArrayList<>();
            //临时的字串存储空间
            ArrayList<String> tempStr = new ArrayList<>();
            //循环
            for(int i=0; i<strChar.length; i++){
                //char -> String
                String str = new String(new char[]{strChar[i]});
                //判断str是否存在于tempStr中
                if(tempStr.contains(str)){
                    //先判断tempStr的长度是否大于等于maxStr的长度,大于，才能将最长字串覆盖
                    if(tempStr.size() > maxStr.size()){
                        maxStr = new ArrayList<>(tempStr);
                    }
                    //存储重复字符
                    int reIndex = tempStr.indexOf(str);
                    // 删除tempStr中的重复字节及其之前的字符
                    for(int j=0;j<=reIndex;j++){
                        tempStr.remove(0);
                    }
                }
                //将当前字符存入tempStr中
                tempStr.add(str);
            }
            //最终判断
            if(tempStr.size() > maxStr.size()){
                maxStr = tempStr;
            }
            //返回最长字串的长度
            return maxStr.size();
        }
        return 0;
    }*/
    //2.0
    public int lengthOfLongestSubstring(String str) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = str.length();

        int res = 0;//定义初始未重复字符长度
        int start = 0; // 窗口开始位置，表示未出现重复时出现的位置
        for(int i = 0; i < n; i++) {
            //获取第i个字符的 ascii  码
            int index = str.charAt(i);
            //获取窗口开始的位置，如果同一字符出现重复，获取第一次出现的位置，从该位置的下一位置开始计算
            start = Math.max(start, last[index] + 1);
            //从后往前推，返回的是长度 i-start+1:表示 当前位置-窗口开始位置后的下一个位置距离为未重复的最大距离
            res   = Math.max(res, i - start + 1);
            //赋值 当前字符出现的位置
            last[index] = i;
        }
        return res;
    }
    //3.0 官方版 没有2.0 好
/*    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }*/
    @Test
    void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
