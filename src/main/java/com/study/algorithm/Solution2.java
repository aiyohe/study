package com.study.algorithm;

import org.junit.jupiter.api.Test;

/**
 * @Author: zhangqian
 * @Date: 2022/8/18
 * @Description:
 */
public class Solution2 {
    /**
     *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //1.0
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //循环处理l1获取数据
        int[] number1=new int[10];
        int i=0;
        ListNode ls1=l1;
        while (ls1!=null){
            number1[i]=ls1.val;
            ls1=ls1.next;
            i++;
            if(i==10){
                break;
            }
        }
        //循环处理l2获取数据
        int[] number2=new int[10];
        int j=0;
        ListNode ls2=l2;
        while (ls2!=null){
            number2[j]=ls2.val;
            ls2=ls2.next;
            j++;
            if(j==10){
                break;
            }
        }
        //获取总和
        int n1=0;
        for (int k = 0; k <=i; k++) {
            n1+=number1[k]*(Math.pow(10,i-k-1));
        }
        int n2=0;
        for (int k = 0; k <=j; k++) {
            n2+=number2[k]*(Math.pow(10,j-k-1));
        }
        int n=n1+n2;
        //拼凑结果集
        ListNode rs=new ListNode();
        ListNode ln=rs;
        while (n>0){
            int i1 = n % 10;
            n=n/10;
            ln.val=i1;
            if(n>0){
                ln.next=new ListNode();
                ln=ln.next;
            }
        }
        return rs;
    }
    //2.0 --摘抄
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
    @Test
    void test(){
        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(9)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4,new ListNode(9))));
        ListNode ln = this.addTwoNumbers(l1, l2);
        ListNode ls=ln.next;
        System.out.print(ln.val+",");
        while (ls!=null){
            System.out.print(ls.val+",");
            ls=ls.next;
        }
        System.out.println();
    }
}
