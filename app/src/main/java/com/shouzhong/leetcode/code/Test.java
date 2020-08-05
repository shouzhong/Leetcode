package com.shouzhong.leetcode.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        int[] visited = new int[numCourses];
        for (int[] temp : prerequisites) {
            edges.get(temp[1]).add(temp[0]);
        }
        boolean[] bs = {true};
        for (int i = 0; i < numCourses && bs[0]; i++) {
            if (visited[i] == 0) canFinish(edges, visited, bs, i);
        }
        return bs[0];
    }

    public void canFinish(List<List<Integer>> edges, int[] visited, boolean[] bs, int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                canFinish(edges, visited, bs, v);
                if (!bs[0]) return;
            } else if (visited[v] == 1) {
                bs[0] = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
