package com.shouzhong.leetcode.code;

import com.bumptech.glide.request.SingleRequest;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public void solve(char[][] board) {
        int len1= board.length;
        if (len1 == 0) return;
        int[] dx = {1, -1, 0 ,0};
        int[] dy = {0, 0, 1, -1};
        int len2 = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
            }
            if (board[i][len2 - 1] == 'O') {
                queue.offer(new int[] {i, len2 - 1});
            }
        }
        for (int i = 1; i < len2 - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[] {0, i});
            }
            if (board[len1 - 1][i] == 'O') {
                queue.offer(new int[] {len1 - 1, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= len1 || my >= len2 || board[mx][my] != 'O') continue;
                queue.offer(new int[] {mx, my});
            }
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}
