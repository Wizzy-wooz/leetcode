package leetcode_challenges.april.day20;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC1008ConstructBinarySearchTreeFromPreorderTraversalTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(12);

        LC1008ConstructBinarySearchTreeFromPreorderTraversal instance = new LC1008ConstructBinarySearchTreeFromPreorderTraversal();
        assertEquals(root.val, instance.bstFromPreorder(new int[]{8,5,1,7,10,12}).val);
    }
}
