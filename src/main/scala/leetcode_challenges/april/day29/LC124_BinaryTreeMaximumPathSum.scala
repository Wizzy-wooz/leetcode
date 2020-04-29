package leetcode_challenges.april.day29

object LC124_BinaryTreeMaximumPathSum {
//  Given a non-empty binary tree, find the maximum path sum.
//
//    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//    Example 1:
//
//  Input: [1,2,3]
//
//   1
//  / \
// 2   3
//
//  Output: 6
//  Example 2:
//
//  Input: [-10,9,20,null,null,15,7]
//
//  -10
//  / \
// 9  20
//  /  \
//15   7
//
//  Output: 42

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  var maxSum: Int = _

  def maxPathSum(root: TreeNode): Int = {
    maxSum = root.value
    getDownwardPathSum(root)
    maxSum
  }

  def getDownwardPathSum(node: TreeNode): Int = {
    if (node == null) return 0

    val leftSum = Math.max(0, getDownwardPathSum(node.left))
    val rightSum = Math.max(0, getDownwardPathSum(node.right))
    // Update maxSum if needed.
    maxSum = Math.max(maxSum, leftSum + rightSum + node.value)

    Math.max(leftSum, rightSum) + node.value
  }
}
