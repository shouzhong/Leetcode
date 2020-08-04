package com.shouzhong.leetcode.code

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    val len = nums.size
    if (len == 0) return 0
    var start = 0
    var end = len - 1
    while (true) {
        val index = (start + end) / 2
        if (nums[index] == target) return index
        if (nums[index] > target) {
            if (index == start) return start
            if (index == start + 1 && nums[start] < target) return index
            end = index - 1
        } else {
            if (index == end) return end + 1
            if (index == end - 1 && nums[end] > target) return end
            start = index + 1
        }
    }
}