/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    Two Sum
 Difficulty: Easy
 Source:     https://leetcode.com/problems/two-sum/
 
 Describe:
 ��һ�����У��ҳ�������֮�͵���target��������ǵ����
 
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 
 Type:����
 
 Solution:
 ������Ҫ�����±꣬���Բ���������
 ����һO(n^2)������ѭ��������Ѱ�Ҳ���¼���
 ������O(n)��HashMap��keyΪԭ�����ֵ��mappingΪԭ������ţ�Ȼ��Ѱ��map���Ƿ���target - nums[i]��containsKey�����ҵ�����Է���
 
 */

package com.tang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	public static int[] twoSum(int[] nums, int target) {

		int len = nums.length;

		/* ������ʱ�临�Ӷ�O(n^2) */
		// for (int i = 0; i < len; i++) {
		// for (int j = i + 1; j < len; j++) {
		// if (nums[i] + nums[j] == target) {
		// return new int[] { i, j };
		// }
		// }
		// }

		/* HashMap����:ʱ�临�Ӷ�O(n) 
		 * map.containsKeyʱ�临�Ӷ�O(1)
		 * */
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) }; // ֱ�ӷ���һ����new�Ķ���
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
