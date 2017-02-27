/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Feb 26, 2017
 Problem:    Remove Duplicates from Sorted Array II
 Difficulty: Medium
 Source:     https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?tab=Description
 
 Describe:
 给一已排序数组，删除重复元素，使得每个元素最多出现两次(可延伸到最多出现k次)，求出删除后的数组长度。
 注意：这里也还应该同时记录数组还剩什么元素
 
 Example:
 Given nums = [1, 1, 1, 2, 3, 3, 3, 3, 3, 3]
 return 5
 
 Type:数组
 
 Solution:
 分析三种情况：
 1、后元素和前元素不等，那么直接添加到数组
 2、后元素和前元素相等，但元素只重复了一次，则也添加到数组
 3、后元素和前元素相等，但已经重复两次或以上，则不添加到数组
 注意：这里需要一个变量记录元素已经重复了多少次
 
 网上更简便方法：
 当前元素和nums[lengthDeletedArray - 2]比较；这里用lengthDeletedArray相当于与新数组中的元素比较了，很好
 int lengthDeletedArray = 0;
 for (int n : nums) {
	if (lengthDeletedArray < 2 || n != nums[lengthDeletedArray - 2]) { // 这里使用的是lengthDeletedArray，也就相当于新数组了
		nums[lengthDeletedArray++] = n; 
	}
 }
 return lengthDeletedArray;
 
 该题可推广到：重复元素最多允许出现k次
 if (lengthDeletedArray < k || n != nums[lengthDeletedArray - k]) {
	nums[lengthDeletedArray++] = n; 
 }
 
 */

package com.tang.leetcode;

public class Remove_Duplicates_from_Sorted_Array_II {

	public static int removeDuplicates(int[] nums) {
		int lengthOriginalArray = nums.length; // 原数组长度
		if (lengthOriginalArray == 0) {
			return 0;
		}
		int lengthDeletedArray = 0; // 删除后数组长度
		nums[lengthDeletedArray++] = nums[0]; // 第一个元素添加到数组
		int countDuplicateNumber = 1; // 使用变量记录前面元素已经重复了多少次
		for (int i = 1; i < lengthOriginalArray; i++) {
			if (nums[i] != nums[i - 1]) { // 若不等，则直接添加到数组；并且重置变量countDuplicateNumber为1
				countDuplicateNumber = 1;
				nums[lengthDeletedArray++] = nums[i];
			} else if (countDuplicateNumber < 2) { // 若相等但重复次数只有1次，也添加到数组中；并且将变量countDuplicateNumber加1
				countDuplicateNumber++;
				nums[lengthDeletedArray++] = nums[i];
			} else { // 否则直接将变量countDuplicateNumber加1
				countDuplicateNumber++;
			}
		}
		return lengthDeletedArray;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3 }));
	}

}
