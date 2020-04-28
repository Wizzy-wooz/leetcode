package leetcode_challenges.april.day20

object LC1008_ConstructBinarySearchTreeFromPreorderTraversal {
  //  Return the root node of a binary search tree that matches the given preorder traversal.
  //
  //  (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
  //
  //
  //
  //  Example 1:
  //
  //  Input: [8,5,1,7,10,12]
  //  Output: [8,5,10,1,7,null,12]
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    def build(cursor: Int, minimum: Int, maximum: Int): (TreeNode, Int) =
      if (cursor >= preorder.length) {
        (null, cursor)
      } else {
        val value = preorder(cursor)
        if (value > minimum && value < maximum) {
          val (left, leftCursor) = build(cursor + 1, minimum, value)
          val (right, rightCursor) = build(leftCursor, value, maximum)

          val node = new TreeNode(value)
          node.left = left
          node.right = right

          (node, rightCursor)
        } else {
          (null, cursor)
        }
      }

    build(0, Int.MinValue, Int.MaxValue)._1
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }
}
