package leetcode_challenges.april.day28

import org.scalatest.FlatSpec

class LC_FirstUniqueTest extends FlatSpec{

  "LC_FirstUnique" should "add and show unique values properly." in {
    val firstUnique = new LC_FirstUnique(Array(2, 3, 5))
    assert(firstUnique.showFirstUnique === 2)
    firstUnique.add(5)
    assert(firstUnique.showFirstUnique === 2)
    firstUnique.add(2)
    assert(firstUnique.showFirstUnique === 3)
    firstUnique.add(3)
    assert(firstUnique.showFirstUnique === -1)
  }
}
