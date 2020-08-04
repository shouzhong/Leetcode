package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 */
fun threeSum(nums: IntArray): List<List<Int>>? {
    val list: MutableList<List<Int>> = ArrayList()
    val len = nums.size
    if (len < 3) return list
    Arrays.sort(nums)
    for (i in 0 until len - 2) {
        if (nums[i] > 0) break
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var left = i + 1
        var right = len - 1
        while (left < right) {
            val temp = nums[left] + nums[right] + nums[i]
            when {
                temp == 0 -> {
                    list.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) left++
                    while (left < right && nums[right] == nums[right + 1]) right--
                }
                temp > 0 -> {
                    right--
                }
                else -> {
                    left++
                }
            }
        }
    }
    return list
}