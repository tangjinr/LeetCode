/*
 
 Author:     tangz, tangpersonal@163.com
 Date:       Feb 27, 2017
 Problem:    Climbing Stairs
 Difficulty: Easy
 Source:     https://leetcode.com/problems/climbing-stairs/?tab=Description
 
 Describe:
 假设一个楼梯有n梯，每次只能爬1梯或2梯，求出有多少种爬的方式
 
 Example:
 Given n = 2
 return 2
 
 Type:数组
 
 Solution:
 第一直觉，递归：f(n) = f(n - 1) + f(n - 2)，但太慢，因为会重复计算很多次f(k)(k <= n)
 首先：考虑preNumDistinctWays记录前一梯的方法数
 然后：令当前方法数distinctWays，加上前一梯preNumDistinctWays方法数，就是下一梯求的方法数；distinctWays += preNumDistinctWays;
 注意：用零时变量temp记录distinctWays，因为需要更新preNumDistinctWays = temp
 
 网上也有斐波那契公式，可百度
 
 */

package com.tang.leetcode;

public class Climbing_Stairs {

	public static int climbStairs(int n) {
		int preNumDistinctWays = 0; // 前一梯的方法数
		int distinctWays = 1;  // 求的总方法数
		for (int i = 1; i <= n; i++) {
			int temp = distinctWays;
			distinctWays += preNumDistinctWays;
			preNumDistinctWays = temp;
		}
		return distinctWays;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(10));
	}

}