package com.shouzhong.leetcode

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 */
fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val temp = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
        for (j in 0..i) {
            temp[j] = Math.min(temp[j], temp[j + 1]) + triangle[i][j]
        }
    }
    return temp[0]
}