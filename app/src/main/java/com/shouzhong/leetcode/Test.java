package com.shouzhong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Test {
    public String countAndSay(int n) {
        if (n < 1) return "";
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            char temp = s.charAt(i);
            if (temp == c) count++;
            else {
                sb.append(count).append(c);
                c = temp;
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}
