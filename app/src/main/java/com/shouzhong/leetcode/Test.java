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
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else  {
                result = Math.max(result, prices[i] - min);
            }
        }
        return result;
    }
}
