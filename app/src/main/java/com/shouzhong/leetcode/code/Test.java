package com.shouzhong.leetcode.code;

import com.bumptech.glide.request.SingleRequest;

public class Test {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int index = -1;
        int num0 = 0;
        int num1 = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (index != 0) {
                    result += Math.min(num0, num1);
                    num0 = 0;
                }
                num0++;
                index = 0;
            } else if (c == '1') {
                if (index != 1) {
                    result += Math.min(num0, num1);
                    num1 = 0;
                }
                num1++;
                index = 1;
            }
        }
        result += Math.min(num0, num1);
        return result;
    }
}
