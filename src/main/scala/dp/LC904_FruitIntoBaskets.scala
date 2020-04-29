package dp

object LC904_FruitIntoBaskets {
  //    In a row of trees, the i-th tree produces fruit with type tree[i].
  //
  //    You start at any tree of your choice, then repeatedly perform the following steps:
  //
  //    Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
  //    Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
  //    Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
  //
  //    You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
  //
  //    What is the total amount of fruit you can collect with this procedure?
  //  res - the best found solution
  //    p1 - the previous element
  //  l1 - length of the longest suffix consisting only of p1
  //  p2 - an element before the previous, the longest suffix consisting of p1 and p2 is what we are searching for
  //  l2 - length of the longest suffix consisting of p1 and p2
  //    t - the current type of fruit

  def totalFruit(tree: Array[Int]): Int =
    tree.foldLeft((0, -1, 0, -1, 0)) { case ((res, p1, l1, p2, l2), t) => t match {
      case `p1` => (res max (l2 + 1), p1, l1 + 1, p2, l2 + 1)
      case `p2` => (res max (l2 + 1), p2, 1, p1, l2 + 1)
      case _ => (res max (l1 + 1), t, 1, p1, l1 + 1)
    }
    }._1
}
