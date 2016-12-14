package com.tang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*title:3Sum*/
public class Three_Sum {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int len = nums.length;

		List<List<Integer>> resultList = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = len - 1;
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
					resultList.add(Arrays.asList(a, b, c));
					j++;
					k--;
					while (nums[j] == nums[j - 1] && j < k)
						j++;
					while (nums[k] == nums[k + 1] && j < k)
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
