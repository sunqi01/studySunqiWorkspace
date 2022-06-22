package com.dbic.leetcode.erFenChaZhao;

public class SearchTarget {
//	给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
//	写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//
//	输入: nums = [-1,0,3,5,9,12], target = 9
//	输出: 4
//	解释: 9 出现在 nums 中并且下标为 4
	public int search(int[] nums, int target) {
		int result = -1;
		int len = nums.length;
		int left = 0;
		int right = len -1;
		while(left<=right) {
			int pre = (right-left)/2 + left;
			if(nums[pre] == target) {
				return pre;
			}
			else if(nums[pre]>target) {
				right = pre -1;
			}else {
				left = pre +1;
			}
		}
		return result;
    }
	
	public static void main(String[] args)
	throws Exception{
		
		int nums[] = new int[] {5};
		SearchTarget searchTarget = new SearchTarget();
		System.out.println(searchTarget.search(nums, 5));
	}

}
