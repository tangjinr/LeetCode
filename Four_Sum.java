package com.tang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*title:4Sum*/
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
