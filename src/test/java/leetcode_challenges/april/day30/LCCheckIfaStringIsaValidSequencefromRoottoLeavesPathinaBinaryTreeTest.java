package leetcode_challenges.april.day30;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LCCheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTreeTest {
    @Test
    public void test(){
        TreeNode root = new TreeNode(0);
        TreeNode roo9 = new TreeNode(1);
        root.left = roo9;
        TreeNode roo20 = new TreeNode(0);
        root.right = roo20;

        TreeNode root2 = new TreeNode(0);
        roo9.left = root2;

        TreeNode root3 = new TreeNode(1);
        roo9.right = root3;

        LCCheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree c =
                new LCCheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree();

        assertTrue(c.isValidSequence(root,new int[]{0,1,1}));
    }
}
