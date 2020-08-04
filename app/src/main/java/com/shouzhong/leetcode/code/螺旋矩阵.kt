package com.shouzhong.leetcode.code

import java.util.*

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list: MutableList<Int> = ArrayList()
    val m = matrix.size
    if (m == 0) return list
    val n: Int = matrix[0].size
    if (n == 0) return list
    var l = 0
    var r = n - 1
    var t = 0
    var b = m - 1
    while (l <= r && t <= b) {
        for (i in l..r) {
            list.add(matrix[t][i])
        }
        for (i in t + 1..b) {
            list.add(matrix[i][r])
        }
        if (l < r && t < b) {
            for (i in r - 1 downTo l + 1) {
                list.add(matrix[b][i])
            }
            for (i in b downTo t + 1) {
                list.add(matrix[i][l])
            }
        }
        l++
        r--
        t++
        b--
    }
    return list
}

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 */
fun generateMatrix(n: Int): Array<IntArray> {
    val result = Array(n) { IntArray(n) }
    if (n == 0) return result
    var index = 1
    var l = 0
    var r = n - 1
    var t = 0
    var b = n - 1
    while (l <= r && t <= b) {
        for (i in l..r) {
            result[t][i] = index++
        }
        for (i in t + 1..b) {
            result[i][r] = index++
        }
        if (l < r && t < b) {
            for (i in r - 1 downTo l + 1) {
                result[b][i] = index++
            }
            for (i in b downTo t + 1) {
                result[i][l] = index++
            }
        }
        l++
        r--
        t++
        b--
    }
    return result
}