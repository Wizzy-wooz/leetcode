package dp

object LC337_HouseRobberIII {
  /**
    * The thief has found himself a new place for his thievery again. There is only
    * one entrance to this area, called the "root." Besides the root, each house
    * has one and only one parent house. After a tour, the smart thief realized
    * that "all houses in this place forms a binary tree". It will automatically
    * contact the police if two directly-linked houses were broken into on the
    * same night.
    *
    * Determine the maximum amount of money the thief can rob tonight without alerting the police.
    *
    * Example 1:
    *
    * 3
    * / \
    * 2   3
    * \   \
    * 3   1
    *
    * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    *
    * Example 2:
    *
    * 3
    * / \
    * 4   5
    * / \   \
    * 1   3   1
    *
    * Maximum amount of money the thief can rob = 4 + 5 = 9.
    *
    */

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
   var value: Int = _value
   var left: TreeNode = _left
   var right: TreeNode = _right
  }

  def rob(root: TreeNode): Int = {
    Math.max(rob(root, parentSafe = false), rob(root, parentSafe = true))
  }

  /**
    *
    * @param node given node
    * @param parentSafe whether current node's parent has been robbed already
    * @return the maximum value obtainable by robbing houses incl / below current node
    */
  def rob(node: TreeNode, parentSafe: Boolean): Int = {
    if(null == node)
      0
    else {
      if(parentSafe) {
        Math.max(
          node.value + rob(node.left, parentSafe = false) + rob(node.right, parentSafe = false),
          rob(node.left, parentSafe = true) + rob(node.right, parentSafe = true)
        )
      } else {
        rob(node.left, parentSafe = true) + rob(node.right, parentSafe = true)
      }
    }
  }
}
