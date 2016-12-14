/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    4Sum
 Difficulty: Medium
 Source:     https://leetcode.com/problems/4sum/
 
 Describe:
 ��һ�����У��ҳ��ĸ���֮�͵���target�������������a + b + c + d = target
 
 Example:
 Given S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [
   [-1,  0, 0, 1],
   [-2, -1, 1, 2],
   [-2,  0, 0, 2]
 ]
 
 Type:����
 
 Solution:
 ͬ3Sum��������Ȼ���˻���������֮�ͣ����üб�Ѱ������Ҫ���nums[i]+nums[j]+nums[k]+nums[l]=target����Ҫȥ��
 �������k����֮�͵���target����˼�룺
 ����һO(N^K)�� ����������ö�����е�K-subset
 ������O(n^(K-1))��
 ���������Լ����ڼб���������֮�ͣ�O(NlogN)���Ļ���
 Ȼ���ǣ���ȷ��һ����������ʣ�µ��������ҵ�ʣ�µ�k-1������ʹ����֮�͵���target �C �Ǹ�ȡ������
 k-1�����ֿ��˻�����k-2�������Դ����ƣ����ֻ��Ҫ���2����֮��
 
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
