package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 */
fun permute(nums: IntArray): List<List<Int>>? {
    val lists: MutableList<List<Int>> =
        ArrayList()
    val len = nums.size
    if (len == 0) return lists
    permute(lists, nums, ArrayList(), 0)
    return lists
}

fun permute(
    lists: MutableList<List<Int>>,
    nums: IntArray,
    list: List<Int>,
    index: Int
) {
    if (index == nums.size) {
        lists.add(list)
        return
    }
    val size = list.size + 1
    for (i in 0 until size) {
        val temp: ArrayList<Int> = ArrayList(list)
        temp.add(i, nums[index])
        permute(lists, nums, temp, index + 1)
    }
}

fun permuteUnique(nums: IntArray): List<List<Int>>? {
    val len = nums.size
    val res: MutableList<List<Int>> =
        ArrayList()
    if (len == 0) {
        return res
    }
    // 排序（升序或者降序都可以），排序是剪枝的前提
    Arrays.sort(nums)
    // 使用 Deque 是 Java 官方 Stack 类的建议
    permuteUnique(nums, 0, BooleanArray(len), ArrayDeque(len), res)
    return res
}

fun permuteUnique(
    nums: IntArray,
    depth: Int,
    used: BooleanArray,
    path: Deque<Int>,
    res: MutableList<List<Int>>
) {
    val len = nums.size
    if (depth == len) {
        res.add(ArrayList(path))
        return
    }
    for (i in 0 until len) {
        if (used[i]) {
            continue
        }

        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue
        }
        path.addLast(nums[i])
        used[i] = true
        permuteUnique(nums, depth + 1, used, path, res)
        // 回溯部分的代码，和 dfs 之前的代码是对称的
        used[i] = false
        path.removeLast()
    }
}