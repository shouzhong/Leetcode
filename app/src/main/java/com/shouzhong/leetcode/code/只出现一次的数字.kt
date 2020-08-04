package com.shouzhong.leetcode.code

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 */
fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices) {
        result = result xor nums[i]
    }
    return result
}

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 以下算法对于任意大于等于2的重复次数均适用
 *
 */
fun singleNumber2(nums: IntArray): Int {
    val temp = IntArray(32)
    for (num in nums) {
        var num = num
        for (i in 0..31) {
            temp[i] += num and 1
            num = num ushr 1
        }
    }
    var result = 0
    val m = 3
    for (i in 31 downTo 0) {
        result = result shl 1
        result += temp[i] % m
    }
    return result
}