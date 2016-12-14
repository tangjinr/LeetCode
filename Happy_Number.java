/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    Happy Number
 Difficulty: Easy
 Source:     https://leetcode.com/problems/happy-number/
 
 Describe:
 给定一个数，判断是否是Happy Number；Happy Number对每个数字求平方和，如果最后等于1，则是Happy Number；如果最后出现无限循环，则不是Happy Number
 
 Example:
 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 
 Type:数论
 
 Solution:
 多次求平方和，判断平方和是否为1，若是直接返回true；
 否则将平方和结果记录下来，若后面求得平方和已经在前面出现过，直接返回false（因为会无限循环下去）
 
 */

package com.tang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (set.add(n)) {
			// sum计算各个数字平方和
			int sum = 0;
			while (n != 0) {
				int num = n % 10;
				sum += Math.pow(num * 1.0, 2.0);
				n /= 10;
			}
			// 判断平方和是否为1,
			if (sum == 1)
				return true;
			// 将sum赋值给n，进行下次检验
			n = sum;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(1));
	}

}
