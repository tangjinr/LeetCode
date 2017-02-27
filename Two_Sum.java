/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2016
 Problem:    Two Sum
 Difficulty: Easy
 Source:     https://leetcode.com/problems/two-sum/
 
 Describe:
 在一数组中，找出两个数之和等于target，输出它们的序号
 
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 
 Type:数组
 
 Solution:
 该题需要数组下标，所以不能排序处理
 方法一O(n^2)：两层循环，暴力寻找并记录序号
 方法二O(n)：HashMap，key为原数组的值，mapping为原来的序号，然后寻找map中是否含有target - nums[i]（containsKey），找到则可以返回
 
 */

package com.tang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	public static int[] twoSum(int[] nums, int target) {

		int len = nums.length;

		/* 暴力，时间复杂度O(n^2) */
		// for (int i = 0; i < len; i++) {
		// for (int j = i + 1; j < len; j++) {
		// if (nums[i] + nums[j] == target) {
		// return new int[] { i, j };
		// }
		// }
		// }

		/*
		 * HashMap方法:时间复杂度O(n) map.containsKey时间复杂度O(1)
		 */
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) }; // 直接返回一个新new的对象(匿名对象)
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 3, 6 };
		int target = 4;
		twoSum(nums, target);
	}

}