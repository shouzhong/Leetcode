package com.shouzhong.leetcode.code

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(map[target - nums[i]]!!, i)
        }
        map[nums[i]] = i
    }
    return null
}

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 */
fun twoSum2(numbers: IntArray, target: Int): IntArray? {
    val len: Int = numbers.size
    var index1 = 0
    var index2 = len - 1
    while (index1 < index2) {
        val temp: Int = numbers[index1] + numbers[index2]
        if (temp == target) return intArrayOf(index1 + 1, index2 + 1)
        if (temp > target) index2-- else index1++
    }
    return null
}