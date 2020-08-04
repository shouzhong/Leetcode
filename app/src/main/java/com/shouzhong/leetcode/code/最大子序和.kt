package com.shouzhong.leetcode.code

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 */
fun maxSubArray(nums: IntArray): Int {
    val len = nums.size
    var result = nums[0]
    var sum = 0
    for (i in 0 until len) {
        sum = Math.max(sum + nums[i], nums[i])
        result = Math.max(result, sum)
    }
    return result
}