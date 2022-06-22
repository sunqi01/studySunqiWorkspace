package com.dbic.leetcode.digui;

public class IsPowerOfTwo {
	
	//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
	//如果存在一个整数 x 使得 n = 2的x次方 ，则认为 n 是 2 的幂次方。

	public boolean isPowerOfTwo(int n) {
        if(n>2147483647||n<1) {
			return false;
		}
		
		if(n==1) {
			return true;
		}
		//除不尽肯定不是2的幂次方
		if(n%2!=0) {
			return false;
		}else {
			
			//2的0次方等于1  不能再除了
			return isPowerOfTwo(n/2);//除以2 往下递归
		}
		
		
    }
	
	public static void main(String[] args)
	throws Exception{
		IsPowerOfTwo a = new IsPowerOfTwo();
		System.out.println(a.isPowerOfTwo(3));
		System.out.println(Integer.toBinaryString(4));
		char c= '4';
		System.out.println(Integer.toBinaryString(c));
		System.out.println(c);
		
	}
}
