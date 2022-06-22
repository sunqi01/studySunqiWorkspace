package com.dbic.leetcode.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

//	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//	有效字符串需满足：
//
//	左括号必须用相同类型的右括号闭合。
//	左括号必须以正确的顺序闭合。
//	 
//
//	示例 1：
//	输入：s = "()"
//	输出：true
//	示例 2：
//	输入：s = "()[]{}"
//	输出：true
//	示例 3：
//	输入：s = "(]"
//	输出：false
//	示例 4：
//	输入：s = "([)]"
//	输出：false
//	示例 5：
//	输入：s = "{[]}"
//	输出：true
	
	public boolean isValid(String s) {
		
		String inArr = "({[";;
		String outArr = ")}]";
		
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
		int length = s.length();
		for(int i=0;i<length;i++) {
			if(inArr.indexOf(s.charAt(i))>-1) {
				stack.push(s.charAt(i));
			}else if(outArr.indexOf(s.charAt(i))>-1){
				if(stack.empty()) {
					return false;
				}
				char out = stack.pop();
				if(out!=map.get(s.charAt(i))) {
					return false;
				}
			}else {
				return false;
			}
		}
		if(!stack.empty()) {
			return false;
		}else {
			return true;
		}
    }
	
	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("[]{}[]{}()"));
	}

}
