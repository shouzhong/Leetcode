package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（包括空集）。
 * 解集不能包含重复的子集。
 *
 */
fun subsets(nums: IntArray): List<List<Int>> {
    val lists: MutableList<List<Int>> = ArrayList()
    lists.add(ArrayList())
    val len = nums.size
    for (i in 0 until len) {
        val size = lists.size
        for (j in 0 until size) {
            val temp: MutableList<Int> = ArrayList(lists[j])
            temp.add(nums[i])
            lists.add(temp)
        }
    }
    return lists
}

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（包括空集）。
 * 说明：解集不能包含重复的子集。
 *
 */
fun subsetsWithDup(nums: IntArray): List<List<Int>>? {
    val lists: MutableList<List<Int>> =
        ArrayList()
    lists.add(ArrayList())
    val len = nums.size
    Arrays.sort(nums)
    var start = 0
    for (i in 0 until len) {
        val size = lists.size
        for (j in start until size) {
            val temp: MutableList<Int> = ArrayList(lists[j])
            temp.add(nums[i])
            lists.add(temp)
        }
        start = if (i < len - 1 && nums[i] == nums[i + 1]) size else 0
    }
    return lists
}