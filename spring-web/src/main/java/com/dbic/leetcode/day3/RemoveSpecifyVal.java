package com.dbic.leetcode.day3;

public class RemoveSpecifyVal {
	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int p=0,q = 0;
		while(p<length) {
			if(nums[p]!=val) {
				nums[q] = nums[p];
				++q;
			}
			++p;
		}
		return q;
    }
}
