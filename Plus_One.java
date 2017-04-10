/*

 Author:     tangz, tangpersonal@163.com
 Date:       Apr 10, 2017
 Problem:    Plus One
 Difficulty: Easy
 Source:     https://leetcode.com/problems/plus-one/#/description

 Describe:
 给一个用数组（只包含数字）代表的非负整数，对这个整数进行加1操作，输出最后结果，该结果还是用数组保存

 Example:
 Given n = 999，digits = [9,9,9]
 return [1,0,0,0]

 Type:数组

 Solution:
 时间复杂度O(n)，空间负责度O(1)
 从digits的最后一位开始向前操作
 1、进行加tempAddNum（本题是1）操作：digits[i] += tempAddNum;
 2、然后令tempAddNum = digits[i] / 10;
 若加完之后的digits[i]小于10，则tempAddNum = 0，此时可返回结果
 若加完之后的digits[i]大于等于10，则tempAddNum = 1或者更大的数，此时继续操作digits的下一个数字
 3、然后这里还需要对digits[i] %= 10;操作
 4、回到第1步
 5、若最后检验完digits[0]，tempAddNum依然大于0，则需要在数组最前面加个元素tempAddNum：这里进行数组复制，然后tempDigits[0] = tempAddNum;

 网上很简单的方法:该方法只能处理加1操作
 public int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
}

 */

package com.tang.leetcode;

public class Plus_One {

    public static int[] plusOne(int[] digits) {
        return add(digits, 1);
    }

    private static int[] add(int[] digits, int addNum) {
        int digitsLength = digits.length;
        int tempAddNum = addNum, i = digitsLength - 1;
        while (tempAddNum != 0 && i >= 0) {
            digits[i] += tempAddNum;
            tempAddNum = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        if (tempAddNum != 0) {
            int[] tempDigits = new int[digitsLength + 1];
            System.arraycopy(digits, 0, tempDigits, 1, digitsLength);
            tempDigits[0] = tempAddNum;
            return tempDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ans = plusOne(new int[]{0});
        for (int x : ans) {
            System.out.print(x);
        }
    }
}
