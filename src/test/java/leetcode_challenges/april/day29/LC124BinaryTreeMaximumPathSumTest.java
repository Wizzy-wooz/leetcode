package leetcode_challenges.april.day29;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LC124BinaryTreeMaximumPathSumTest {
    @Test
    public void testFidMax() {
        LC124BinaryTreeMaximumPathSum instance = new LC124BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        assertEquals(instance.maxPathSum(root), 6);
    }
}

