package bit_manipulation

object LC137SingleNumber2 {
  def singleNumber(nums: Array[Int]): Int = nums.foldLeft((0,0))((count, e)  =>
    (count._2 & e | count._1 & ~e,
      ~ count._1 & (count._2 ^ e)
    ))._2
}
