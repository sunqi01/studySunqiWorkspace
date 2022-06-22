package com.dbic.leetcode.day5;

public class LengthOfLastWord {
	//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
	//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

	
	public int lengthOfLastWord(String s) {
		int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
	
	public static void main(String[] args)
	throws Exception{
		
		LengthOfLastWord a = new LengthOfLastWord();
		System.out.println(a.lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println(a.lengthOfLastWord("hello world "));
		
		String s = "hello world ";
		int len = s.length();
		int pre = -1;
		int max = 1;
		for(int i=0;i<len;i++) {
			
			if(s.charAt(i)==' ') {
				if(i==0) {
					max = Math.max(max, i-pre);
				}else {
					max = Math.max(max, i-pre);
				}
				pre = i;
				
			}
		}
		System.out.println("==max;="+max); 
	}
}
