package com.shouzhong.leetcode

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(map[target - nums[i]]!!, i)
        }
        map[nums[i]] = i
    }
    return null
}