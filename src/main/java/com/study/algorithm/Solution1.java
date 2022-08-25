package com.study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangqian
 * @Date: 2022/8/18
 * @Description:
 */
public class Solution1 {
    /**
     * 两数之和
     *
     * @Descirpion: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-sum
     */
    public int[] twoSum(int[] nums, int target) {

        int[] subs = new int[2];//获取下标
        int count = nums.length;
        //v1.0 O(n²)
            /*for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if(i==j){
                        continue;
                    }
                    if(nums[i]+nums[j]==target){
                        subs[0]=i;
                        subs[1]=j;
                        return subs;
                    }
                }
            }*/
        //v2.0
            /*List<Integer> list = Arrays.asList(ArrayUtils.toObject(nums));
            for (int i = 0; i < count; i++) {
                int source = target - nums[i];
                if(list.contains(source)){
                    Integer ints = list.indexOf(source);
                    subs[0]=i;
                    subs[1]=ints;
                    break;
                }
            }*/
        //V3.0
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int source = target - nums[i];
            if (numMap.containsKey(source)) {
                subs[0] = numMap.get(source);
                subs[1] = i;
                break;
            }
            numMap.put(nums[i], i);
        }

        return subs;
    }
    @Test
    public void SolutionTest() {
        int[] nums = {3, 2, 4};
        int[] subs = new  Solution1().twoSum(nums, 6);
        System.out.println(subs[0] + "-" + subs[1]);
    }
}
