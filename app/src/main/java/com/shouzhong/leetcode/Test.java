package com.shouzhong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return list;
        Arrays.sort(nums);
        if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) {
            return list;
        }
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (target < min) break;
            int max = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (target > max) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = len - 1;
                min = nums[i] + nums[j] + nums[left] + nums[left + 1];
                if (target < min) break;
                max = nums[i] + nums[j] + nums[right] + nums[right - 1];
                if (target > max) continue;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (temp > target) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                    }
                }
            }
        }
        return list;
    }
}
