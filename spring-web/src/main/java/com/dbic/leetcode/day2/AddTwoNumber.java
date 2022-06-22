package com.dbic.leetcode.day2;

import java.util.List;

public class AddTwoNumber {

	//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	//请你将两个数相加，并以相同形式返回一个表示和的链表。
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	
	//输入：l1 = [2,4,3], l2 = [5,6,4]
	//	输出：[7,0,8]
	//	解释：342 + 465 = 807.
	
	//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	//输出：[8,9,9,9,0,0,0,1]
	
	
	
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		int yushu = 0;
		ListNode result = null;
		ListNode resultNext = null;
		while(l1!=null||l2!=null) {
			
			int valOfl1 = l1.val;
			int valOfl2 = l2.val;
			//除以10的整数位 向下一位进    取余作为这一位的val
			yushu = (valOfl1 + valOfl2+yushu)/10;
			int resultVal =  (valOfl1 + valOfl2+yushu)%10;
			if(l1!=null) {
				l1 = l1.next;
			}
			if(l2!=null) {
				l2 = l2.next;
			}
			
			result = new ListNode(resultVal);
			resultNext = new ListNode();
			result.next = resultNext;
			
		}
		if(yushu>0){
	           resultNext.next =  new ListNode(yushu);
        }
		return result;  
        
    }
	
}
