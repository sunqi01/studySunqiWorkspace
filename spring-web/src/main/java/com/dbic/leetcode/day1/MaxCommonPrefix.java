package com.dbic.leetcode.day1;

public class MaxCommonPrefix {

	//编写一个函数来查找字符串数组中的最长公共前缀。
	//如果不存在公共前缀，返回空字符串 ""。
	//示例 ：

	//输入：strs = ["flower","flow","flight"]
	//输出："fl"
	
	//横向扫描
	//先把第一个字符串和第二个字符串的公共前缀弄出来，再把这个前缀拿去跟第三个字符串看它们的公共前缀，依次类推
	//依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
	
	public String getCommonPrefix(String[] strArr)
	throws Exception{
		int length = strArr.length;
		String commonPrefix = strArr[0];
		for(int i=0;i<length;i++) {
			commonPrefix = getCommonPrefix(commonPrefix,strArr[i]);
			if("".equals(commonPrefix)) {
				break;
			}
		}
		return commonPrefix;
	}
	
	public String getCommonPrefix(String a,String b)
	throws Exception{
		int aLength = a.length();
		int bLength = b.length();
		int minLength = Math.min(aLength, bLength);
		//两个字符串的公共前缀的长度肯定不可能比 较短的那个字符串的长度长
		
		//那怎么看两个字符串的公共前缀列。只能一个个比咧
		String commonPrefix = "";
		for(int i=0;i<minLength;i++)
		{
			if(a.charAt(i)==b.charAt(i)) {
				commonPrefix += a.charAt(i);
			}else {
				break;
			}
		}
		return commonPrefix;
	}
//	时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
//	空间复杂度：O(1)。使用的额外空间复杂度为常数。
	
	
	//纵向扫描
	//从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
	//如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
            	System.out.println("i=="+i);
            	System.out.println("strs[j].length()=="+strs[j].length());
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


	
	public static void main(String[] args)
	throws Exception{
		MaxCommonPrefix maxCommonPrefix = new MaxCommonPrefix();
		System.out.println("公共前缀===="+maxCommonPrefix.getCommonPrefix("abcdefg", "abthrht"));
		String[] strArr = {"abcdefg","b","abcd"};
		System.out.println(maxCommonPrefix.getCommonPrefix(strArr));
		System.out.println(maxCommonPrefix.longestCommonPrefix(strArr));
		
	}
}
