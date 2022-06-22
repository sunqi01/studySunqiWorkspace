package com.dbic.leetcode.day7;

public class StrIndexOfTest {

//	给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//	说明：
//	当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//	对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
	
	//暴力
	public int strStr(String haystack, String needle) {
		int haystackLen = haystack.length();
		int needleLen = needle.length();
		
		
		 
		for(int i=0;i<=haystackLen-needleLen;i++) {
			boolean piPei = true;
			for(int j=0;j<needleLen;j++) {
				if(haystack.charAt(i+j)!=needle.charAt(j)) {
					System.out.println("2222=i=="+haystack.charAt(i));
					System.out.println("2222=j=="+needle.charAt(j));

					piPei = false;
					break;
				}
			}
			
			if(piPei) {
				return i;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args)
	{
		String a = "mississippi";
		String b = "mississippi";
		StrIndexOfTest strIndexOfTest = new StrIndexOfTest();
		System.out.println(strIndexOfTest.strStr(a, b));
	}

}
