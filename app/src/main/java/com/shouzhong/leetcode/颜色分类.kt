package com.shouzhong.leetcode

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 不能使用代码库中的排序函数来解决这道题。
 *
 */
fun sortColors(nums: IntArray) {
    val len = nums.size
    var index0 = 0
    var index2 = len - 1
    var i = 0
    while (i <= index2) {
        if (nums[i] == 0) {
            if (i == index0) {
                index0++
            } else {
                val temp = nums[index0]
                nums[index0] = nums[i]
                nums[i] = temp
                index0++
            }
        } else if (nums[i] == 2) {
            if (i == index2) {
                index2--
            } else {
                val temp = nums[index2]
                nums[index2] = nums[i]
                nums[i] = temp
                index2--
                if (nums[i] != 1) i--
            }
        }
        i++
    }
}