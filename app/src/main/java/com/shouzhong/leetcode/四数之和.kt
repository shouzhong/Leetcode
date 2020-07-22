package com.shouzhong.leetcode

import java.util.*

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 答案中不可以包含重复的四元组。
 */
fun fourSum(
    nums: IntArray,
    target: Int
): List<List<Int>>? {
    val list: MutableList<List<Int>> =
        ArrayList()
    val len = nums.size
    if (len < 4) return list
    Arrays.sort(nums)
    if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) {
        return list
    }
    for (i in 0 until len - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]
        if (target < min) break
        var max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]
        if (target > max) continue
        for (j in i + 1 until len - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue
            var left = j + 1
            var right = len - 1
            min = nums[i] + nums[j] + nums[left] + nums[left + 1]
            if (target < min) break
            max = nums[i] + nums[j] + nums[right] + nums[right - 1]
            if (target > max) continue
            while (left < right) {
                val temp = nums[i] + nums[j] + nums[left] + nums[right]
                when {
                    temp == target -> {
                        list.add(
                            listOf(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                            )
                        )
                        left++
                        right--
                        while (left < right && nums[left] == nums[left - 1]) left++
                        while (left < right && nums[right] == nums[right + 1]) right--
                    }
                    temp > target -> {
                        right--
                        while (left < right && nums[right] == nums[right + 1]) right--
                    }
                    else -> {
                        left++
                        while (left < right && nums[left] == nums[left - 1]) left++
                    }
                }
            }
        }
    }
    return list
}