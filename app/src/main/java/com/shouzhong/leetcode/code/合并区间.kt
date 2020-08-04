package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val len = intervals.size
    if (len == 0) return Array(0) { IntArray(2) }
    val list = ArrayList<IntArray>()
    Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] }
    var temp = intArrayOf(intervals[0][0], intervals[0][1])
    for (i in 1 until len) {
        if (intervals[i][0] <= temp[1]) {
            temp[1] = Math.max(temp[1], intervals[i][1])
        } else {
            list.add(temp)
            temp = intArrayOf(intervals[i][0], intervals[i][1])
        }
    }
    list.add(temp)
    val result = Array(list.size) { IntArray(2) }
    list.toArray(result)
    return result
}