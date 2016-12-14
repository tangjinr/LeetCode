/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    3Sum
 Difficulty: Medium
 Source:     https://leetcode.com/problems/3sum/
 
 Describe:
 ��һ�����У��ҳ�������֮�͵���0��target���������������a + b + c = 0
 
 Example:
 Given S = [-1, 0, 1, 2, -1, -4]
 A solution set is:
 [
   [-1, 0, 1],
   [-1, -1, 2]
 ]
 
 Type:����
 
 Solution:
 ����ֻ��Ҫ�ļ����������������Ȼ��ʹ�üб�Ѱ��O��n��
 ��ȷ��һ��i���������˻���������j,k�����üб�Ѱ������Ҫ���nums[i]+nums[j]+nums[k]=0�����ﻹ��Ҫȥ��
 ���ڴ�˼�룬�����ƹ㵽k����֮�͵���target��Four_Sum.java�н��ܾ���˼��
 
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
			// �б�Ѱ��������֮��
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
					resultList.add(Arrays.asList(a, b, c));// Arrays.asList����Arrays��һ���ڲ���
					j++;
					k--;
					while (nums[j] == nums[j - 1] && j < k) // �����ظ���Ԫ��
						j++;
					while (nums[k] == nums[k + 1] && j < k) // �����ظ���Ԫ��
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
