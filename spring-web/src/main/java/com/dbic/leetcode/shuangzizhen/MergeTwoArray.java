package com.dbic.leetcode.shuangzizhen;

public class MergeTwoArray {
	//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
	//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
	//注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
	//其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1=0,p2=0;
		int[] newArr = new int[m+n];
		int cur;
		while(p1<m||p2<n) {
            if(p1==m){
                cur = nums2[p2];
                p2 = p2 +1 ;
            }else if(p2==n){
                 cur = nums1[p1];
                 p1 = p1 +1 ;
            }

			else if(nums1[p1]<nums2[p2]) {
				cur = nums1[p1];
				p1 = p1 +1 ;
			}else {
				cur = nums2[p2];
				p2 = p2 +1 ;
			}
			
			newArr[p1+p2-1] = cur;
		}
		
		for (int i = 0; i != m + n; ++i) {
            nums1[i] = newArr[i];
        }
    }
	
	public static void main(String[] args)
	throws Exception{
		for(int i=0;i<10;++i) {
			System.out.println(i);
		}
		System.out.println("=======");
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		//那如果把i++替换成++i，有什么不一样吗？
		//首先这涉及到for循环语句的执行顺序问题：
		//①int i = 0；初始变量
		//②i < 5; 判断语句
		//关键–③ 循环体中的逻辑代码
		//④i++（或++i）变量自增
		//看到这里应该明白了，for循环中i++和++i其实对执行结果没有产生影响，都是最后才自增1。
		
		System.out.println("=======");
		int a = 0;
		System.out.println(a++);
		System.out.println(a++);
		System.out.println(a++);
		System.out.println("=======");
		int b = 0;
		System.out.println(++b);
		System.out.println(++b);
		System.out.println(++b);
		
		
		
	}

}
