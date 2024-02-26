package ua.nure.cpp.lab1.strings;

public class BinaryTree {
    TreeNode root;

    BinaryTree(TreeNode root) {
        this.root = root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
