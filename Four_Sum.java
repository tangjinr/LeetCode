/*

 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    4Sum
 Difficulty: Medium
 Source:     https://leetcode.com/problems/4sum/
 
 Describe:
 在一数组中，找出四个数之和等于target，输出这三个数a + b + c + d = target
 
 Example:
 Given S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [
   [-1,  0, 0, 1],
   [-2, -1, 1, 2],
   [-2,  0, 0, 2]
 ]
 
 Type:数组
 
 Solution:
 同3Sum，先排序，然后退化到两个数之和，利用夹逼寻找满足要求的nums[i]+nums[j]+nums[k]+nums[l]=target，需要去重
 这里介绍k个数之和等于target具体思想：
 方法一O(N^K)： 暴力，就是枚举所有的K-subset
 方法二O(n^(K-1))：
 基于排序，以及基于夹逼求两个数之和（O(NlogN)）的基础
 然后考虑，先确定一个数，再在剩下的数字中找到剩下的k-1个数，使他们之和等于（target – 那个确定的数）
 k-1个数又可退化到求k-2个数，以此类推，最后只需要求得2个数之和
 
 */

package com.tang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);
		int len = nums.length;

		List<List<Integer>> resultList = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < len; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1, l = len - 1;
				while (k < l) {
					int a = nums[i];
					int b = nums[j];
					int c = nums[k];
					int d = nums[l];
					if (a + b + c + d == target) {
						resultList.add(Arrays.asList(a, b, c, d));
						k++;
						l--;
						while (nums[k] == nums[k - 1] && k < l)
							k++;
						while (nums[l] == nums[l + 1] && k < l)
							l--;
					} else if (a + b + c + d > target) {
						l--;
						while (nums[l] == nums[l + 1] && k < l)
							l--;
					} else {
						k++;
						while (nums[k] == nums[k - 1] && k < l)
							k++;
					}
				}
			}
		}

		// System.out.println(resultList);
		return resultList;

	}

	public static void main(String[] args) {
		int[] S = { 0, 0, 0, 0 };
		int target = 0;
		fourSum(S, target);
	}

}
