/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Feb 27, 2017
 Problem:    Remove Element
 Difficulty: Easy
 Source:     https://leetcode.com/problems/remove-element/?tab=Description
 
 Describe:
 给一数组中，删除指定的元素，求出删除后的数组长度。
 注意：这里还应该同时记录数组还剩什么元素（这点题目没描述清楚）
 
 Example:
 Given nums = [9, 1, 5, 2, 2, 3, 2, 4]， val = 2
 return 5
 
 Type:数组
 
 Solution:
 只需要比较数组中元素是否和指定元素不等：若不等，则长度直接加1
 
 */

package com.tang.leetcode;

public class Remove_Element {

	public static int removeElement(int[] nums, int val) {
		int lengthOriginalArray = nums.length; // 原数组长度
		int lengthDeletedArray = 0;
		for(int i = 0; i < lengthOriginalArray; i++) {
			if(nums[i] != val) { // 不等于指定元素，则直接添加
				nums[lengthDeletedArray++] = nums[i];
			}
		}
		return lengthDeletedArray;
	}

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 9, 1, 5, 2, 2, 3, 2, 4}, 2));
	}

}
