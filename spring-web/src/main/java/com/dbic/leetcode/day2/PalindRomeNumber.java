package com.dbic.leetcode.day2;

public class PalindRomeNumber {

	//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
	//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	//例如，121 是回文，而 123 不是。

	public boolean isPalindrome(int x)
	{
		//负数应该肯定不是吧
		if(x<0) {
			return false;
		}else {
			String str = Integer.toString(x);
			StringBuffer stringBuffer = new StringBuffer(str);
			
			if(str.equals(stringBuffer.reverse().toString())) {
				return true;
			}else {
				return false;
			}
		}
		
		
		
		//为啥下面这个 比我上面的快而且内存占用少
//		if (x < 0 || (x % 10 == 0 && x != 0)) {
//            return false;
//        }
//
//        int revertedNumber = 0;
//        while (x > revertedNumber) {
//            revertedNumber = revertedNumber * 10 + x % 10;
//            x /= 10;
//        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
//        return x == revertedNumber || x == revertedNumber / 10;
	}
	
	public static void main(String[] args)
	throws Exception{
		PalindRomeNumber palindRomeNumber = new PalindRomeNumber();
		System.out.println(palindRomeNumber.isPalindrome(1233211));
	}
}
