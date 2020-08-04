package com.shouzhong.leetcode.code

import java.util.*
import kotlin.math.abs

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    val len = nums.size
    Arrays.sort(nums)
    var result = 20000
    for (i in 0 until len - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var left = i + 1
        var right = len - 1
        while (left < right) {
            val temp = nums[i] + nums[left] + nums[right]
            if (temp == target) return temp
            if (abs(target - temp) < abs(target - result)) result = temp
            if (temp > target) {
                right--
                while (left < right && nums[right] == nums[right + 1]) right--
            } else {
                left++
                while (left < right && nums[left] == nums[left - 1]) left++
            }
        }
    }
    return result
}