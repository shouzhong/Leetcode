package com.shouzhong.leetcode.code

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 */
fun nextPermutation(nums: IntArray) {
    val len = nums.size
    var index1 = -1
    for (i in len - 2 downTo 0) {
        if (nums[i] < nums[i + 1]) {
            index1 = i
            break
        }
    }
    if (index1 >= 0) {
        var index2 = len - 1
        for (i in len - 1 downTo 0) {
            if (nums[i] > nums[index1]) {
                index2 = i
                break
            }
        }
        val temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp
    }
    var left = index1 + 1
    var right = len - 1
    while (left < right) {
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
        left++
        right--
    }
}