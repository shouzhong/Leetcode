package com.shouzhong.leetcode.code;

public class Test {
    public int rob(TreeNode root) {
        int[] sums = robDfs(root);
        return Math.max(sums[0], sums[1]);
    }

    public int[] robDfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] l = robDfs(root.left);
        int[] r = robDfs(root.right);
        int selected = root.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] {selected, notSelected};
    }

    public enum A {
        INSTANCE;

        public void a() {

        }
    }
}
