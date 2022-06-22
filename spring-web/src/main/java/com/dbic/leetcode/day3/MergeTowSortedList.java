package com.dbic.leetcode.day3;

public class MergeTowSortedList {

	//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//	输入：l1 = [1,2,4], l2 = [1,3,4]
//	输出：[1,1,2,3,4,4]
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) 
		{ this.val = val; this.next = next; }
		
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		if(list1==null) {
			return list2;
		}
		if(list2==null) {
			return list1;
		}
		if(list1.val<list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		}
		else {
			list2.next = mergeTwoLists(list2.next, list1);
			return list2;
		}
    }
	
}

