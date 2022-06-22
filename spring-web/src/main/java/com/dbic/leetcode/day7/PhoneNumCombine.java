//package com.dbic.leetcode.day7;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PhoneNumCombine {
//	static Map<Integer,String> map = new HashMap<>();
//	
//
//	//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//	//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//	public List<String> letterCombinations(String digits) {
//		
//		map.put(2, "abc");
//		map.put(3, "def");
//		map.put(4, "ghi");
//		map.put(5, "jkl");
//		map.put(6, "mno");
//		map.put(7, "pqrs");
//		map.put(8, "tuv");
//		map.put(9, "wxyz");
//		
//		int len = digits.length();
//		StringBuffer buf = new StringBuffer();
//		for(int i=0;i<len;i++) {
//			int charInt = Integer.parseInt(Character.toString(digits.charAt(i)));
//			String charStr = map.get(charInt);
//			int charStrLen = charStr.length();
//			for(int j=0;j<charStrLen;j++) {
//				buf.append(charStr.charAt(j));
//			}
//			
//		}
//    }
//	
//	private void backTrack(int index,String digits,StringBuffer buf) {
//		int digitsLen = digits.length();
//		
//		for(int i=0;i<digitsLen;i++) {
//		}
//		
//	}
//}
