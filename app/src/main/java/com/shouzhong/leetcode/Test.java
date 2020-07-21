package com.shouzhong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public String intToRoman(int num) {
        if (num == 0) return "";
        int count = num / 1000;
        if (count > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < count; i++) {
                sb.append('M');
            }
            return sb.toString() + intToRoman(num % 1000);
        }
        count = num / 900;
        if (count > 0) {
            return "CM" + intToRoman(num % 900);
        }
        count = num / 500;
        if (count > 0) {
            return "D" + intToRoman(num % 500);
        }
        count = num / 400;
        if (count > 0) {
            return "CD" + intToRoman(num % 400);
        }
        count = num / 100;
        if (count > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < count; i++) {
                sb.append('C');
            }
            return sb.toString() + intToRoman(num % 100);
        }
        count = num / 90;
        if (count > 0) {
            return "XC" + intToRoman(num % 90);
        }
        count = num / 50;
        if (count > 0) {
            return "L" + intToRoman(num % 50);
        }
        count = num / 40;
        if (count > 0) {
            return "XL" + intToRoman(num % 40);
        }
        count = num / 10;
        if (count > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < count; i++) {
                sb.append('X');
            }
            return sb.toString() + intToRoman(num % 10);
        }
        count = num / 9;
        if (count > 0) {
            return "IX" + intToRoman(num % 9);
        }
        count = num / 5;
        if (count > 0) {
            return "V" + intToRoman(num % 5);
        }
        count = num / 4;
        if (count > 0) {
            return "IV" + intToRoman(num % 4);
        }
        count = num;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append('I');
        }
        return sb.toString();
    }
}
