package com.tang.leetcode;

import java.util.HashSet;
import java.util.Set;

/*title:Happy Number*/
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
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(1));
	}

}
