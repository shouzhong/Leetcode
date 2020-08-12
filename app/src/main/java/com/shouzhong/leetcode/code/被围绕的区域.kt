package com.shouzhong.leetcode.code

import java.util.*

fun solve(board: Array<CharArray>) {
    val len1 = board.size
    if (len1 == 0) return
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val len2: Int = board[0].size
    val queue: Queue<IntArray> = LinkedList()
    for (i in 0 until len1) {
        if (board[i][0] == 'O') {
            queue.offer(intArrayOf(i, 0))
        }
        if (board[i][len2 - 1] == 'O') {
            queue.offer(intArrayOf(i, len2 - 1))
        }
    }
    for (i in 1 until len2 - 1) {
        if (board[0][i] == 'O') {
            queue.offer(intArrayOf(0, i))
        }
        if (board[len1 - 1][i] == 'O') {
            queue.offer(intArrayOf(len1 - 1, i))
        }
    }
    while (!queue.isEmpty()) {
        val cell = queue.poll()
        val x = cell[0]
        val y = cell[1]
        board[x][y] = 'A'
        for (i in 0..3) {
            val mx = x + dx[i]
            val my = y + dy[i]
            if (mx < 0 || my < 0 || mx >= len1 || my >= len2 || board[mx][my] != 'O'
            ) continue
            queue.offer(intArrayOf(mx, my))
        }
    }
    for (i in 0 until len1) {
        for (j in 0 until len2) {
            if (board[i][j] == 'A') board[i][j] = 'O' else if (board[i][j] == 'O'
            ) board[i][j] = 'X'
        }
    }
}