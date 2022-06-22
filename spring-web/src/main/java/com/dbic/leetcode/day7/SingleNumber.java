package com.dbic.leetcode.day7;

public class SingleNumber {

	//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	
	//位运算
	//异或运算有以下三个性质。
	//任何数和 0 做异或运算，结果仍然是原来的数，即 a^0=a 
	//任何数和其自身做异或运算，结果是 0，即 a^a=0 
	//异或运算满足交换律和结合律，即 a^ b ^a=b ^ a ^ a=b ^ (a^ a)=b ^0=b

	public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
