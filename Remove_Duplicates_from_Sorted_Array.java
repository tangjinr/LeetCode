/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Feb 26, 2017
 Problem:    Remove Duplicates from Sorted Array
 Difficulty: Easy
 Source:     https://leetcode.com/problems/remove-duplicates-from-sorted-array/?tab=Description
 
 Describe:
 给一已排序数组，删除重复元素，使得每个元素只出现一次，求出删除后的数组长度。
 注意：这里还应该同时记录数组还剩什么元素（这点题目没描述清楚）
 
 Example:
 Given nums = [1, 1, 1, 2, 2, 3, 3, 4]
 return 4
 
 Type:数组
 
 Solution:
 只需要比较后一个元素和前一个元素是否不等：nums[i] != nums[i - 1]
 若不等，则长度需要加1处理
 一个技巧：判断第一个元素时采用if (i == 0 || nums[i] != nums[i - 1])
 
 网上较好的解答技巧：
 比较后一个元素和新数组（nums[lengthDeletedArray - 1]）中的前一个元素是否不等：nums[i] != nums[lengthDeletedArray - 1]
 
 */

package com.tang.leetcode;

public class Remove_Duplicates_from_Sorted_Array {

	public static int removeDuplicates(int[] nums) {
		int lengthOriginalArray = nums.length; // 原数组长度
		if (lengthOriginalArray == 0) {
			return 0;
		}
		int lengthDeletedArray = 0; // 删除后数组长度
		for (int i = 0; i < lengthOriginalArray; i++) {
			// 判断：若是第一个元素，或者后一个元素和前一个元素不等 这两种情况，则都需要加1
			if (i == 0 || nums[i] != nums[i - 1]) {
				// 这里题目没有说清楚：必须要同时记录，不能直接lengthDeletedArray++，否则会Wrong Answer
				nums[lengthDeletedArray++] = nums[i];
			}
		}
		return lengthDeletedArray;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

}
