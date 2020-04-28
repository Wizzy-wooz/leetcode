package leetcode_challenges

import leetcode_challenges.april.day1.LC136_SingleNumber
import org.scalatest.FlatSpec

class LC136_SingleNumberTest extends FlatSpec {

    "SingleNumber" should "find single number in given a non-empty array of integers " +
      "where every element appears twice except for one." in {
    assert(LC136_SingleNumber.singleNumber(Array(1,2,1,3,3)) === 2)
    }

  "SingleNumber" should "return -1 when there is no single number in given a non-empty array of integers " +
    "where every element appears twice except for one." in {
    assert(LC136_SingleNumber.singleNumber(Array(1,1,3,3)) === -1)
  }
}
