package leetcode_challenges.april.day30

import org.scalatest.FlatSpec

class LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTreeTest extends FlatSpec{

  "LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree" should
    "check if a String is a valid sequence from root to Leaves Path in a Binary Tree." in {
    val root = new LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.TreeNode(0)
    val roo9 = new LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.TreeNode(1)
    root.left = roo9
    val roo20 = new LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.TreeNode(0)
    root.right = roo20
    val root2 = new LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.TreeNode(0)
    roo9.left = root2
    val root3 = new LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.TreeNode(1)
    roo9.right = root3

    assert(LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree.isValidSequence(root, Array(0,1,1)) === true)
  }
}
