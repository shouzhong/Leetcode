package com.shouzhong.leetcode.code

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 */
fun minPathSum(grid: Array<IntArray>): Int {
    val len1 = grid.size
    if (len1 == 0) return 0
    val len2: Int = grid[0].size
    if (len2 == 0) return 0
    for (i in 0 until len1) {
        for (j in 0 until len2) {
            if (i == 0 && j == 0) continue else if (i == 0) grid[i][j] =
                grid[i][j - 1] + grid[i][j] else if (j == 0) {
                grid[i - 1][j] = grid[i][j]
                grid[i][j] = grid[i - 1][j]
            } else grid[i][j] =
                grid[i - 1][j].coerceAtMost(grid[i][j - 1]) + grid[i][j]
        }
    }
    return grid[len1 - 1][len2 - 1]
}