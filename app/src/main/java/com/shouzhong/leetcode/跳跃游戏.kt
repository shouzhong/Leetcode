package com.shouzhong.leetcode

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 */
fun canJump(nums: IntArray): Boolean {
    var index = nums.size - 2
    var min = 1
    while (index >= 0) {
        if (nums[index] >= min) {
            min = 1
        } else {
            min++
        }
        index--
    }
    return min == 1
}