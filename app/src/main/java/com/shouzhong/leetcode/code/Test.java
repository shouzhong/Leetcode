package com.shouzhong.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int n = word.length();
            if (n == 0) continue;
            for (int j = 0; j <= n; j++) {
                if (palindromePairs(word, j, n - 1)) {
                    Integer leftIndex = map.get(word.substring(0, j));
                    if (leftIndex != null && leftIndex != i) lists.add(Arrays.asList(i, leftIndex));
                }
                if (j != 0 && palindromePairs(word, 0, j - 1)) {
                    Integer rightIndex = map.get(word.substring(j, n));
                    if (rightIndex != null && rightIndex != i) lists.add(Arrays.asList(rightIndex, i));
                }
            }
        }
        return lists;
    }

    public boolean palindromePairs(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
