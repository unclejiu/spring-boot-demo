package com.easy.leetcode;

import java.util.Arrays;

/*
75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Sub75 {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        Solution_75 solution = new Solution_75();
        solution.sortColors(nums);
        System.out.println("返回结果为：" + Arrays.toString(nums));
    }
}

/**
 * 三指针解法
 */
class Solution_75 {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, cur = 0, t;
        while (cur <= p2) {
            if (nums[cur] == 0 && cur != p1) {
                t = nums[p1];
                nums[p1] = nums[cur];
                nums[cur] = t;
                p1++;
            } else if (nums[cur] == 2) {
                t = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = t;
                p2--;
            } else {
                cur++;
            }
            //System.out.println(String.format("p1=%d,p2=%d,cur=%d,数组=%s", p1, p2, cur, Arrays.toString(nums)));
        }
    }
}