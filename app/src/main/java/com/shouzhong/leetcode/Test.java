package com.shouzhong.leetcode;

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
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int current = 0;
        int total = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            int temp = gas[i] - cost[i];
            total += temp;
            current += temp;
            if (current < 0) {
                index = i + 1;
                current = 0;
            }
        }
        return total >= 0 ? index : -1;
    }
}
