package com.dbic.leetcode.day6;

public class PlusOne {
	//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

	//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

	//你可以假设除了整数 0 之外，这个整数不会以零开头。
	
	public int[] plusOne(int[] digits) {
		
//		String s = "";
//		int len = digits.length;
//		for(int i=0;i<len;i++) {
//			s += String.valueOf(digits[i]);
//		}
//		int r = Integer.parseInt(s);
//		
//		String result = String.valueOf(r+1);
//		len = result.length();
//		int[] res = new int[len];
//		for(int j=0;j<len;j++) {
//			res[j] = Integer.parseInt(Character.toString(result.charAt(j)));
//		}
//		return res;   这样写毫无算法可言，而且要输数组长了，会超过int的范围
		
		//从后向前遍历
		int len = digits.length;
		for(int i=len-1;i>-1;i--) {
			//如果最后一位 加1了不等于10  就可以直接return了
			
			++digits[i];
			if(digits[i]!=10) {
				return digits;
			}else {//等于10 就等于0 进1   下一位继续这样
				digits[i] = 0;
			}
		}
		//如果全是9  加1  等于0进1
		
		int[] newDisits = new int[len+1];
		newDisits[0] = 1;
		return newDisits;
		
    }

}
