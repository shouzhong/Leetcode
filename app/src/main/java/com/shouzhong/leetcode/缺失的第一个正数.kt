package com.shouzhong.leetcode

import kotlin.math.abs

fun firstMissingPositive(nums: IntArray): Int {
    val len = nums.size
    if (len == 0) return 1
    for (i in 0 until len) {
        if (nums[i] <= 0) nums[i] = len + 1
    }
    for (i in 0 until len) {
        val num = abs(nums[i])
        if (num <= len) nums[num - 1] = -abs(nums[num - 1])
    }
    for (i in 0 until len) {
        if (nums[i] > 0) return i + 1
    }
    return len + 1
}