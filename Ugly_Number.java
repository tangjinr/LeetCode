/*

 Author:     tangz, tangpersonal@163.com
 Date:       Aug 23, 2017
 Problem:    Ugly Number
 Difficulty: Easy
 Source:     https://leetcode.com/problems/ugly-number/description/

 Describe:
 给定一个数，判断是否是Ugly Number；Ugly Number它的因子只有1,2,3,5(因此1也是Ugly Number)。

 Example:
 6 is a Ugly Number
 6 = 2 * 3
 14 is not a Ugly Number
 14 = 2 * 7

 Type:数论

 Solution:
 把n里面的2,3,5全部消掉，看最后剩下的数是不是1；
 代码上就是首先判断num是否还含有因子2（%2即可），若含有，则num除以2；再循环操作直到不含因子2。
 同样对3,5进行相同操作
 最后得到的数看是否是1

 */

package com.tang.leetcode;

/**
 * Author: tangzhen
 * Package: com.tang.leetcode
 * Name: Ugly_Number
 * Date: 2017/8/23
 * Time: 17:26
 */
public class Ugly_Number {

    public static boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num /= 2;  // 消除所有2因子
        while (num % 3 == 0) num /= 3;  // 消除所有3因子
        while (num % 5 == 0) num /= 5;  // 消除所有5因子
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(22));
    }

}
