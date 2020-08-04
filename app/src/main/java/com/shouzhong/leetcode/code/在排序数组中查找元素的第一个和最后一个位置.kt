package com.shouzhong.leetcode.code

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 */
fun searchRange(nums: IntArray, target: Int): IntArray? {
    var leftIndex = -1
    var rightIndex = -1
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> {
                leftIndex = mid
                right = mid - 1
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                left = mid + 1
            }
        }
    }
    if (leftIndex == -1) return intArrayOf(-1, -1)
    left = leftIndex
    right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            nums[mid] == target -> {
                rightIndex = mid
                left = mid + 1
            }
            nums[mid] > target -> {
                right = mid - 1
            }
            else -> {
                left = mid + 1
            }
        }
    }
    return intArrayOf(leftIndex, rightIndex)
}