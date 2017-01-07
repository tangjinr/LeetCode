/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2016
 Problem:    3Sum
 Difficulty: Medium
 Source:     https://leetcode.com/problems/3sum/
 
 Describe:
 在一数组中，找出三个数之和等于0（target），输出这三个数a + b + c = 0
 
 Example:
 Given S = [-1, 0, 1, 2, -1, -4]
 A solution set is:
 [
   [-1, 0, 1],
   [-1, -1, 2]
 ]
 
 Type:数组
 
 Solution:
 该题只需要哪几个数，则可先排序，然后使用夹逼寻找O（n）
 先确定一个i，三个数退化到两个数j,k，利用夹逼寻找满足要求的nums[i]+nums[j]+nums[k]=0，这里还需要去重
 基于此思想，可以推广到k个数之和等于target，Four_Sum.java中介绍具体思想
 
 */

package com.tang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int len = nums.length;

		List<List<Integer>> resultList = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = len - 1;
			// 夹逼寻找两个数之和
			while (j < k) {
				int a = nums[i];
				int b = nums[j];
				int c = nums[k];
				if (a + b + c == 0) {
					// List<Integer> enumList = new ArrayList<>();
					// enumList.add(a);
					// enumList.add(b);
					// enumList.add(c);
					// resultList.add(enumList);
					resultList.add(Arrays.asList(a, b, c));// Arrays.asList返回Arrays的一个内部类
					j++;
					k--;
					while (nums[j] == nums[j - 1] && j < k) // 消除重复的元素
						j++;
					while (nums[k] == nums[k + 1] && j < k) // 消除重复的元素
						k--;
				} else if (a + b + c > 0) {
					k--;
					while (nums[k] == nums[k + 1] && j < k)
						k--;
				} else {
					j++;
					while (nums[j] == nums[j - 1] && j < k)
						j++;
				}
			}
		}

		// System.out.println(resultList);

		return resultList;
	}

	public static void main(String[] args) {
		int[] S = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		threeSum(S);
	}

}