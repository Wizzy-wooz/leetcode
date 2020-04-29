package leetcode_challenges.april

import leetcode_challenges.april.day29.LC124_BinaryTreeMaximumPathSum
import org.scalatest.FlatSpec

class LC124_BinaryTreeMaximumPathSumTest extends FlatSpec{

  "LC124_BinaryTreeMaximumPathSum" should "find the maximum path sum of given non-empty binary tree." in {
    val root = new LC124_BinaryTreeMaximumPathSum.TreeNode(2)
    root.left = new LC124_BinaryTreeMaximumPathSum.TreeNode(1)
    root.right = new LC124_BinaryTreeMaximumPathSum.TreeNode(3)

    assert(LC124_BinaryTreeMaximumPathSum.maxPathSum(root) === 6)
  }
}
