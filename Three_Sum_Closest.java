/*

 Author: 	 tangz, tangpersonal@163.com
 Date: 		 Apr 10, 2017
 Problem:    3Sum Closest
 Difficulty: Medium
 Source:     https://leetcode.com/problems/3sum-closest/#/description

 Describe:
 在一数组中，求出与target最接近的三个数的和sum，输出该和

 Example:
 Given S = [0, 2, 1, -3]，and target = 1.
 The sum that is closest to the target is 0. (-3 + 1 + 2 = 0).

 Type:数组

 Solution:
 该题需要与target最接近的和
 1、先排序
 2、先确定一个i，三个数退化到两个数j,k，利用夹逼寻求得一个sum = nums[i]+nums[j]+nums[k]
 3、判断sum与target的差值的绝对值与minGap的大小，若小于最小的minGap，则更新minGap和sumResult
 4、判断sum与target的大小，若小于target，则j++（向后继续寻找），否则k--（向前继续寻找）

 该题可以延伸至求与target最接近的k个数的和sum，代码不再写

 */

package com.tang.leetcode;

import java.util.Arrays;

public class Three_Sum_Closest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums); // 对原数组nums从小到大排序
        int numsLength = nums.length;

        int minGap = Integer.MAX_VALUE; // 设定mingGap的初始值为MAX_VALUE
        int sumResult = 0; // 题目告诉肯定有解，所以可以为任意的初始值

        /*夹逼定理求和*/
        for (int i = 0; i < numsLength; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = numsLength - 1;
            while (j < k) {

                final int sum = nums[i] + nums[j] + nums[k]; // 三个数之和
                final int currentGap = Math.abs(sum - target);  // 计算sum与target的差值
                /*若当前差值小于最小差值，则更新*/
                if (currentGap < minGap) {
                    minGap = currentGap;
                    sumResult = sum;
                }

                /*若小于target，则j++（向后继续寻找），否则k--（向前继续寻找）*/
                if (sum < target) {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                } else {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) {
                        k--;
                    }
                }
            }
        }
        return sumResult;
    }

    public static void main(String[] args) {
        int[] S = {0, 2, 1, -3};
        System.out.println(threeSumClosest(S, 1));
    }

}