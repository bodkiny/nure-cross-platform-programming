package ua.nure.cpp.lab1.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.nure.cpp.lab1.strings.BinaryTree.*;

class StringFromBinaryTreeTest {

    //Disable this test after you have implemented the method
    @Test
    @DisplayName("Should throw UnsupportedOperationException when not implemented")
    void shouldThrowUnsupportedOperationException() {
        TreeNode root = new TreeNode(1, null, null);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        assertThrows(UnsupportedOperationException.class, () -> stringFromBinaryTree.build(binaryTree.root));
    }
}
