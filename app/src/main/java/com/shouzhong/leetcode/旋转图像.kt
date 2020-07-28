package com.shouzhong.leetcode

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 给定 matrix =
 * [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 * ]
 *
 */
fun rotate(matrix: Array<IntArray>) {
    val len = matrix.size
    if (len == 1) return
    val n = len / 2
    for (i in 0 until n) {
        for (j in 0 until len) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[len - j - 1][i]
            matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1]
            matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1]
            matrix[j][len - i - 1] = temp
        }
    }
}