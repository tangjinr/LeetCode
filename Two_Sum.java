/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    Two Sum
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/anagrams/
 Describe:
 
 Type:
 
 Solution:
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

		/* HashMap方法:时间复杂度O(n) */
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) }; // 直接返回一个新new的对象
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
