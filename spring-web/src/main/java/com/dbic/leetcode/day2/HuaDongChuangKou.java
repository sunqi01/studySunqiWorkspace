package com.dbic.leetcode.day2;

import java.util.HashSet;
import java.util.Set;

public class HuaDongChuangKou {

	//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
	
	//输入: s = "abcabcbb"
	//输出: 3 
	//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	
	//输入: s = "bbbbb"
	//		输出: 1
	//		解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	
	//假设我们选择字符串中的第 k 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为rk 。
	//那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 rk 的字符显然是不重复的，并且由于少了原本的第 k 个字符，
	//我们可以尝试继续增大 rk,直到右侧出现了重复字符为止。

	//这样一来，我们就可以使用「滑动窗口」来解决这个问题了：

	//我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 rk ；
	//在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，
	//然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；

	//在枚举结束后，我们找到的最长的子串的长度即为答案。

	
	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int right = 0;
		
		int maxRang = 0;//最大长度
		
		Set<Character> set = new HashSet<>();
		for(int i=0;i<length;i++) {
			if(i!=0) {
				set.remove(s.charAt(i));
			}
			
			//怎么看重复不咧
			
			while(right+1<length&&!set.contains(s.charAt(right+1))) {
				set.add(s.charAt(right+1));
				right = right + 1;
			}
			
			maxRang = Math.max(maxRang, right-i);
		}
		return maxRang;
		
//		 Set<Character> occ = new HashSet<Character>();
//	        int n = s.length();
//	        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//	        int rk = -1, ans = 0;
//	        for (int i = 0; i < n; ++i) {
//	        	System.out.println("111111");
//	            if (i != 0) {
//	                // 左指针向右移动一格，移除一个字符
//	                occ.remove(s.charAt(i - 1));
//	            }
//	            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//	                // 不断地移动右指针
//	                occ.add(s.charAt(rk + 1));
//	                ++rk;
//	            }
//	            // 第 i 到 rk 个字符是一个极长的无重复字符子串
//	            ans = Math.max(ans, rk - i + 1);
//	        }
//	        return ans;
    }
	
	public static void main(String[] args)
	throws Exception{
		HuaDongChuangKou huaDongChuangKou = new HuaDongChuangKou();
		
		System.out.println("====="+huaDongChuangKou.lengthOfLongestSubstring("abcdabcdacbabcdbabdcbadbcdbacbabdabcdef"));
		System.out.println("====="+huaDongChuangKou.lengthOfLongestSubstring(""));
	}
}
