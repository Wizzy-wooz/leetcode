package leetcode_challenges.april.day30

object LC_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
  //    Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
  //
  //    We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
  def isValidSequence(root: TreeNode, arr: Array[Int]): Boolean = {

    def isLeaf(node: TreeNode) = node != null && node.left == null && node.right == null

    def dfs(root: TreeNode, arr: List[Int]): Boolean = {
      arr match {
        // If leaf is reached, than the array should have only a single value matching the leaf node.
        case head :: Nil if root != null && root.value == head => isLeaf(root)
        case head :: tail if root != null && root.value == head =>
          // Either of left or right sub tree will have the remaining sequence.
          dfs(root.left, tail) || dfs(root.right, tail)
        case _ => false
      }
    }

    dfs(root, arr.toList)
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

}
