package com.shouzhong.leetcode

import java.util.*

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 */
fun generate(numRows: Int): List<List<Int>>? {
    val lists: MutableList<List<Int>> = ArrayList()
    if (numRows == 0) return lists
    for (i in 0 until numRows) {
        val temp: MutableList<Int> = ArrayList()
        for (j in 0..i) {
            if (j == 0 || j == i) temp.add(1) else temp.add(
                lists[i - 1][j - 1] + lists[i - 1][j]
            )
        }
        lists.add(temp)
    }
    return lists
}

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 */
fun getRow(rowIndex: Int): List<Int>? {
    val list: MutableList<Int> = ArrayList()
    for (i in 0 until rowIndex) {
        list.add(getRow(i, rowIndex - 1))
    }
    return list
}

fun getRow(m: Int, n: Int): Int {
    var m = m
    m = Math.min(m, n - m)
    var result: Long = 1
    for (i in 0 until m) {
        result *= n - i.toLong()
        result /= i + 1.toLong()
    }
    return result.toInt()
}