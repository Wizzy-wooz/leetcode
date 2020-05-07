package leetcode_challenges.may.day7

class LC993_CousinsInBinaryTree {

  //  In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
  //
  //  Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
  //
  //  We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
  //
  //    Return true if and only if the nodes corresponding to the values x and y are cousins.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    def findDepth(toFind: Int, parent: Int, node: TreeNode, actualDepth: Int): Option[(Int, Int)] = {
      if (toFind == node.value) Some(actualDepth, parent)
      else {
        Option(node.left).flatMap(findDepth(toFind, node.value, _, actualDepth + 1))
          .orElse(Option(node.right).flatMap(findDepth(toFind, node.value, _, actualDepth + 1)))
      }
    }

    findDepth(x, root.value, root, 0)
      .zip(findDepth(y, root.value, root, 0))
      .exists(pair => pair._1._2 != pair._2._2 && pair._1._1 == pair._2._1)
  }
}
