package leetcode_challenges.april.day30;

class LCCheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
    //    Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
//
//    We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
    boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }

    private boolean isValidSequence(TreeNode root, int[] arr, int from) {
        if (root == null) {
            return false;
        }
        if (arr.length == from + 1) {
            return root.val == arr[from] && root.left == null && root.right == null;
        }
        if (root.val == arr[from]) {
            return isValidSequence(root.left, arr, from + 1) || isValidSequence(root.right, arr, from + 1);
        }
        return false;
    }
}
