package com.dbic.leetcode.dataconstructor;

public class ReplaceBlank {
//	请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//	示例 1：
//	输入：s = "We are happy."
//	输出："We%20are%20happy."
	
	public String replaceSpace(String s) {
		int len = s.length();
		StringBuffer strBuf = new StringBuffer();
		for(int i=0;i<len;i++) {
			char sChar = s.charAt(i);
			if(sChar==' ') {
				System.out.println("空格");
				strBuf.append("%20");
			}
			else {
				strBuf.append(sChar);
			}
		}
		return strBuf.toString();
    }
	
	public static void main(String[] args)
	throws Exception{
		ReplaceBlank replaceBlank = new ReplaceBlank();
		replaceBlank.replaceSpace("We are happy.");
		
		//看replace方法 也是差不多的实现 
		String a = "abc";
		a.replace("a", "b");
	}
	
	
}
