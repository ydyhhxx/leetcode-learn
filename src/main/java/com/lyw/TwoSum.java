package com.lyw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 num 一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 示例 1：
 *      输入：nums = [2,7,11,15], target = 9
 *      输出：[0,1]
 *      解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * 示例 2：
 *      输入：nums = [3,2,4], target = 6
 *      输出：[1,2]
 *
 * 示例 3：
 *      输入：nums = [3,3], target = 6
 *      输出：[0,1]
 *
 * 提示：
 *      2 <= nums.length <= 104
 *      -109 <= nums[i] <= 109
 *      -109 <= target <= 109
 *      只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n<sup>2</sup>) 的算法吗？
 */
public class TwoSum {
    public static void main(String[] args) {
//        int[] arr = twoSum_2(new int[]{2, 7, 11, 15}, 9);
//        int[] arr = twoSum_2(new int[]{3, 2, 4}, 6);
        int[] arr = twoSum_2(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    public static int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && i != index) {
                return new int[]{i, index};
            }
        }
        return null;
    }
}