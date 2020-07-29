package com.shouzhong.leetcode

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法(空间复杂度O(1))。
 *
 */
fun setZeroes(matrix: Array<IntArray>) {
    var col0_flag = false
    val row = matrix.size
    val col: Int = matrix[0].size
    for (i in 0 until row) {
        if (matrix[i][0] == 0) col0_flag = true
        for (j in 1 until col) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0
                matrix[i][0] = matrix[0][j]
            }
        }
    }
    for (i in row - 1 downTo 0) {
        for (j in col - 1 downTo 1) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
        if (col0_flag) matrix[i][0] = 0
    }
}