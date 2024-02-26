package ua.nure.cpp.lab1.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.nure.cpp.lab1.strings.BinaryTree.*;

class StringFromBinaryTreeTest {

    //Disable this test after you have implemented the method
    @Disabled("Disabled due to method implementation")
    @Test
    @DisplayName("Should throw UnsupportedOperationException when not implemented")
    void shouldThrowUnsupportedOperationException() {
        TreeNode root = new TreeNode(1, null, null);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        assertThrows(UnsupportedOperationException.class, () -> stringFromBinaryTree.build(binaryTree.root));
    }

    @Test
    @DisplayName("Test case 1: root = [1,2,3,4]")
    void testCase1() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        String result = stringFromBinaryTree.build(binaryTree.root);
        assertEquals("1(2(4))(3)", result);
    }

    @Test
    @DisplayName("Test case 2: root = [1,2,3,null,4]")
    void testCase2() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        String result = stringFromBinaryTree.build(binaryTree.root);
        assertEquals("1(2()(4))(3)", result);
    }

    @Test
    @DisplayName("Test case 3: root = [1]")
    void testCase3() {
        TreeNode root = new TreeNode(1);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        String result = stringFromBinaryTree.build(binaryTree.root);
        assertEquals("1", result);
    }

    @Test
    @DisplayName("Test case 4: root = [1,2,null,3]")
    void testCase4() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, node2, null);
        BinaryTree binaryTree = new BinaryTree(root);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        String result = stringFromBinaryTree.build(binaryTree.root);
        assertEquals("1(2(3))", result);
    }

    @Test
    @DisplayName("Test case 5: root = null")
    void testCase5() {
        BinaryTree binaryTree = new BinaryTree(null);
        StringFromBinaryTree stringFromBinaryTree = new StringFromBinaryTree();
        String result = stringFromBinaryTree.build(binaryTree.root);
        assertEquals("", result);
    }
}
