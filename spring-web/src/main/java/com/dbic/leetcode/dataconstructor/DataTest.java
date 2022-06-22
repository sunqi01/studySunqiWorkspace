package com.dbic.leetcode.dataconstructor;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataTest {


	public static void main(String[] args)
	throws Exception{
		//八大数据结构
		
		//数组
		//数组是可以再内存中连续存储多个元素的结构，在内存中的分配也是连续的，
		//数组中的元素通过数组下标进行访问，数组下标从0开始

//		优点：
//		1、按照索引查询元素速度快
//		2、按照索引遍历数组方便
		
//		缺点：
//		1、数组的大小固定后就无法扩容了
//		2、数组只能存储一种类型的数据
//		3、添加，删除的操作慢，因为要移动其他的元素。
		
//		适用场景：
//		频繁查询，对存储空间要求不大，很少增加和删除的情况。
		String[] arr = new String[5];
		String[] arr1 = {"a","b","c"};
		
		System.out.println(arr1[0]);
		
		//栈
		//栈是一种特殊的线性表，仅能在线性表的一端操作，栈顶允许操作，栈底不允许操作。
		//栈的特点是：先进后出，或者说是后进先出，从栈顶放入元素的操作叫入栈，取出元素叫出栈。
		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.pop();
		
		//队列与栈一样，也是一种线性表，不同的是，队列可以在一端添加元素，在另一端取出元素，也就是：先进先出。
		//从一端放入元素的操作称为入队，取出元素为出队
		Queue<String> queue = new LinkedList<>();
		queue.offer("a");
		queue.poll();
		queue.peek();
		
		//链表是物理存储单元上非连续的、非顺序的存储结构，数据元素的逻辑顺序是通过链表的指针地址实现，每个元素包含两个结点，
		//一个是存储元素的数据域 (内存空间)，另一个是指向下一个结点地址的指针域。
		//根据指针的指向，链表能形成不同的结构，例如单链表，双向链表，循环链表等。
//		链表的优点：
//		链表是很常用的一种数据结构，不需要初始化容量，可以任意加减元素；
//		添加或者删除元素时只需要改变前后两个元素结点的指针域指向地址即可，所以添加，删除很快；
		
//		缺点：
//		因为含有大量的指针域，占用空间较大；
//		查找元素需要遍历链表来查找，非常耗时。
		
//		适用场景：
//		数据量较小，需要频繁增加，删除操作的场景
		
		
	}

	
}
