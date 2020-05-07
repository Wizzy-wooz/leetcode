package leetcode_challenges.may.day7;

public class LC993CousinsInBinaryTree {
 //   In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//  Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//  We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//    Return true if and only if the nodes corresponding to the values x and y are cousins.
 public int depth(TreeNode root, int x){
     // If root is null, that means we did not find x
     // s, return minimum
     if(root == null) return Integer.MIN_VALUE;

     // if x is found, return 0
     if(root.val == x) return 0;

     // search in left and right subtrees
     int left = depth(root.left, x);
     int right = depth(root.right, x);

     // now take take max of left and right subtrees
     // and add 1 to it
     return 1 + Math.max(left, right);
 }
    public TreeNode parent(TreeNode root, int x){
        if(root == null) return null;

        // if x is child of root, then return root
        if(root.left != null && root.left.val == x) return root;
        if(root.right != null && root.right.val == x) return root;

        // Search in left and right subtrees
        // if x is found in left subtree, then return left, otherwise right
        TreeNode left = parent(root.left, x);

        if(left != null) return left;

        return parent(root.right, x);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        // two numbers are cousins if they are at same level and
        // have different parents
        return (depth(root, x) == depth(root, y) && parent(root, x) != parent(root, y));
    }
}
