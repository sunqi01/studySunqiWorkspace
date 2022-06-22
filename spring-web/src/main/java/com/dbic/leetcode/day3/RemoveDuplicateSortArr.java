package com.dbic.leetcode.day3;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveDuplicateSortArr {

//	删除有序数组中的重复项
	
	public int removeDuplicates(int[] nums) {
//		Queue<Integer> queue = new LinkedList<>();
//		int length = nums.length;
//		int count = 0;
//		for(int i=0;i<length;i++) {
//			if(!queue.contains(nums[i])) {
//				queue.offer(nums[i]);
//				count = count + 1;
//			}
//		}
//		
//		int queueCount = queue.size();
//		for(int j=0;j<queueCount;j++) {
//			nums[j] = queue.poll();
//		}
//		return count;
		
		//上面自己写的 性能不好 
		
		//双指针
		int n = nums.length;
    	if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }
	
	public static void main(String[] args)
	throws Exception{
		
		int[] nums = {1,1,2};
		RemoveDuplicateSortArr removeDuplicateSortArr = new RemoveDuplicateSortArr();
		System.out.println(removeDuplicateSortArr.removeDuplicates(nums));
	}
}
