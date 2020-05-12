package leetcode_challenges.may.day12

object LC540_SingleElementInASortedArray {
//  You are given a sorted array consisting of only integers where every element appears exactly twice,
//  except for one element which appears exactly once. Find this single element that appears only once.
//
//  Example 1:
//
//  Input: [1,1,2,3,3,4,4,8,8]
//  Output: 2
//  Example 2:
//
//  Input: [3,3,7,7,10,11,11]
//  Output: 10
def singleNonDuplicate(nums: Array[Int]): Int = {
  var len = nums.length
  if(len==1) return nums(0)
  var count = 0
  while(count<len){
    if(count==len-1) return nums(count)
    if(nums(count)!=nums(count+1)) return nums(count)
    count+=2
  }
  count
}
}
