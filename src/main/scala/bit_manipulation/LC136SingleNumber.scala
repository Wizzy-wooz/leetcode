package bit_manipulation

object LC136SingleNumber {
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_^_)
}
