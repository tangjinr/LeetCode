/*
 Author:     tangz, tangpersonal@163.com
 Date:       Dec 13, 2014
 Problem:    Happy Number
 Difficulty: Easy
 Source:     https://leetcode.com/problems/happy-number/
 
 Describe:
 ����һ�������ж��Ƿ���Happy Number��Happy Number��ÿ��������ƽ���ͣ����������1������Happy Number���������������ѭ��������Happy Number
 
 Example:
 19 is a happy number
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 
 Type:����
 
 Solution:
 �����ƽ���ͣ��ж�ƽ�����Ƿ�Ϊ1������ֱ�ӷ���true��
 ����ƽ���ͽ����¼���������������ƽ�����Ѿ���ǰ����ֹ���ֱ�ӷ���false����Ϊ������ѭ����ȥ��
 
 */

package com.tang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (set.add(n)) {
			// sum�����������ƽ����
			int sum = 0;
			while (n != 0) {
				int num = n % 10;
				sum += Math.pow(num * 1.0, 2.0);
				n /= 10;
			}
			// �ж�ƽ�����Ƿ�Ϊ1,
			if (sum == 1)
				return true;
			// ��sum��ֵ��n�������´μ���
			n = sum;
			n = sum;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(1));
	}

}
