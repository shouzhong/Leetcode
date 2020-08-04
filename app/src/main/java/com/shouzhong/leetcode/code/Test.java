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
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0) return num2;
        if (len2 == 0) return num1;
        int len = Math.max(len1, len2);
        int index = 0;
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        while (index < len) {
            char c1 = index < len1 ? num1.charAt(len1 - 1 - index) : '0';
            char c2 = index < len2 ? num2.charAt(len2 - 1 - index) : '0';
            int sum = c1 + c2 - 2 * '0' + temp;
            sb.append(sum % 10);
            temp = sum / 10;
            index++;
        }
        if (temp > 0) sb.append(temp);
        return sb.reverse().toString();
    }
}
