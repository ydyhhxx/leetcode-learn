package com.lyw.array;

import java.lang.annotation.Retention;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/cxqdh/
 *
 * 示例 1:
 *      输入: nums = [1,3,5,6], target = 5
 *      输出: 2
 *
 * 示例 2:
 *      输入: nums = [1,3,5,6], target = 2
 *      输出: 1
 *
 * 示例 3:
 *      输入: nums = [1,3,5,6], target = 7
 *      输出: 4
 *
 * 提示:
 *      1 <= nums.length <= 10<sup>4</sup>
 *      -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 *      nums 为 无重复元素 的 升序 排列数组
 *      -10<sup>4</sup> <= target <= 10<sup>4</sup>
 */
public class SearchInsert {
    public static void main(String[] args) {
        System.out.println("searchInsert=" + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("searchInsert=" + searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("searchInsert=" + searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) { return -1; }
        if (target > nums[nums.length - 1]) { return nums.length; }
        if (target < nums[0]) { return 0; }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + right >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}