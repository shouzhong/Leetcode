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
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int num = nums[0];
        int out = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == num) continue;
            num = nums[i];
            nums[out++] = num;
        }
        return out;
    }
}
