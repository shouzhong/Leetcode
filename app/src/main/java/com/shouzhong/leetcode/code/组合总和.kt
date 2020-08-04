package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 */
fun combinationSum(
    candidates: IntArray,
    target: Int
): List<List<Int>>? {
    val lists: MutableList<List<Int>> =
        ArrayList()
    val len = candidates.size
    if (len == 0) return lists
    Arrays.sort(candidates)
    combinationSum(lists, candidates, target, 0, ArrayList())
    return lists
}

fun combinationSum(
    lists: MutableList<List<Int>>,
    candidates: IntArray,
    target: Int,
    start: Int,
    list: List<Int>
) {
    for (i in start until candidates.size) {
        if (target == candidates[i]) {
            val temp: MutableList<Int> = ArrayList(list)
            temp.add(candidates[i])
            lists.add(temp)
        } else if (target > candidates[i]) {
            val temp: MutableList<Int> = ArrayList(list)
            temp.add(candidates[i])
            combinationSum(lists, candidates, target - candidates[i], i, temp)
        } else {
            break
        }
    }
}

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 */
fun combinationSum2(
    candidates: IntArray,
    target: Int
): List<List<Int>>? {
    val lists: MutableList<List<Int>> =
        ArrayList()
    val len = candidates.size
    if (len == 0) return lists
    Arrays.sort(candidates)
    combinationSum2(lists, candidates, target, 0, ArrayList())
    return lists
}

fun combinationSum2(
    lists: MutableList<List<Int>>,
    candidates: IntArray,
    target: Int,
    start: Int,
    list: List<Int>
) {
    for (i in start until candidates.size) {
        if (i > start && candidates[i] == candidates[i - 1]) {
            continue
        }
        if (target == candidates[i]) {
            val temp: MutableList<Int> = ArrayList(list)
            temp.add(candidates[i])
            lists.add(temp)
        } else if (target > candidates[i]) {
            val temp: MutableList<Int> = ArrayList(list)
            temp.add(candidates[i])
            combinationSum2(lists, candidates, target - candidates[i], i + 1, temp)
        } else {
            break
        }
    }
}