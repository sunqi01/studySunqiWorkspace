package com.dbic.leetcode.day5;

public class MaximiumSubArray {

	
	//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	//子数组 是数组中的一个连续部分。
	
//	输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//	输出：6
//	解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
	
	public int maxSubArray(int[] nums) {

		//方法一 动态规划 
		//我自己的理解，这个问题可以看成 ，以这N个数字作为结尾的子数组，谁的和最大 
		// 如果第N个数  他前面的 第N-1个数字作为结尾的子数组的和 小于0的话,那以第N个数为结尾的子数组的和 一定就是num[i]
		//这个好理解吧  以我前面一个数作为结尾的数组的 最大和 是个负的 那我肯定不能再加他了啊 ，我还不如自己玩 加他 我的和就更小了
		
		
		int n = nums.length;
		int[] result = new int[n];
		result[0] = nums[0];
		
		for(int i=1;i<n;i++) {
			if(result[i-1]<0) {
				result[i] = nums[i];
			}else {
				result[i] =  result[i-1] + nums[i];
			}
		}
		
		for(int m=0;m<n;m++) {
			System.out.println(result[m]);
		}
		
		int res = 0;
		for(int j=0;j<n;j++) {
			
			res = Math.max(result[j], res);
		}
		return res;
    }
	
	public static void main(String[] args)
	throws Exception{
		//[-2,1,-3,4,-1,2,1,-5,4]
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		
		MaximiumSubArray maximiumSubArray = new MaximiumSubArray();
//		maximiumSubArray.maxSubArray({-2,1,-3,4,-1,2,1,-5,4});
		maximiumSubArray.maxSubArray(a);
	}
}
