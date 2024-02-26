package ua.nure.cpp.lab1.strings;

import static ua.nure.cpp.lab1.strings.BinaryTree.*;

public class StringFromBinaryTree {
    StringBuilder sb;

    public StringFromBinaryTree() {
        this.sb = new StringBuilder();
    }

    public String build(TreeNode root) {
        helperTraversal(root);
        return sb.toString();
    }

    private void helperTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        if (node.left != null || node.right != null) {
            sb.append("(");
            helperTraversal(node.left);
            sb.append(")");
        }

        if (node.right != null) {
            sb.append("(");
            helperTraversal(node.right);
            sb.append(")");
        }
    }
}
