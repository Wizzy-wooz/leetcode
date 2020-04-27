package leetcode_30_days_challenge.day20;

public class LC1008ConstructBinarySearchTreeFromPreorderTraversal {
//    Return the root node of a binary search tree that matches the given preorder traversal.
//
//            (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//
//
//    Example 1:
//
//    Input: [8,5,1,7,10,12]
//    Output: [8,5,10,1,7,null,12]
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode currNode = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int num = preorder[i];
            currNode = insertNode(currNode, num);
        }
        return currNode;
    }

    private static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}