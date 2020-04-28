package leetcode_challenges.april.day28

import scala.collection.mutable

class LC_FirstUnique(_nums: Array[Int]) {
  //    You have a queue of integers, you need to retrieve the first unique integer in the queue.
  //
  //    Implement the FirstUnique class:
  //
  //    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
  //    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
  //    void add(int value) insert value to the queue.
  //
  //
  //    Example 1:
  //
  //    Input:
  //            ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
  //            [[[2,3,5]],[],[5],[],[2],[],[3],[]]
  //    Output:
  //            [null,2,null,2,null,3,null,-1]
  //
  //    Explanation:
  //    FirstUnique firstUnique = new FirstUnique([2,3,5]);
  //firstUnique.showFirstUnique(); // return 2
  //firstUnique.add(5);            // the queue is now [2,3,5,5]
  //firstUnique.showFirstUnique(); // return 2
  //firstUnique.add(2);            // the queue is now [2,3,5,5,2]
  //firstUnique.showFirstUnique(); // return 3
  //firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
  //firstUnique.showFirstUnique(); // return -1
  //
  //    Example 2:
  //
  //    Input:
  //            ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
  //            [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
  //    Output:
  //            [null,-1,null,null,null,null,null,17]
  //
  //    Explanation:
  //    FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
  //firstUnique.showFirstUnique(); // return -1
  //firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
  //firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
  //firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
  //firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
  //firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
  //firstUnique.showFirstUnique(); // return 17
  //
  //    Example 3:
  //
  //    Input:
  //            ["FirstUnique","showFirstUnique","add","showFirstUnique"]
  //            [[[809]],[],[809],[]]
  //    Output:
  //            [null,809,null,-1]
  //
  //    Explanation:
  //    FirstUnique firstUnique = new FirstUnique([809]);
  //firstUnique.showFirstUnique(); // return 809
  //firstUnique.add(809);          // the queue is now [809,809]
  //firstUnique.showFirstUnique(); // return -1
  //
  //
  //
  //    Constraints:
  //
  //            1 <= nums.length <= 10^5
  //            1 <= nums[i] <= 10^8
  //            1 <= value <= 10^8
  //    At most 50000 calls will be made to showFirstUnique and add.
  var map = new mutable.HashMap[Integer, Node]()
  var head: Node = new Node()
  var tail: Node = new Node()

  head.next = tail
  tail.prev = head
  tail.value = -1
  for (n <- _nums) {
    if (!map.contains(n)) {
      var node = new Node()
      node.value = n
      map.put(n, node)
      node.prev = tail.prev
      tail.prev = node
      node.prev.next = node
      node.next = tail
    }
    else {
      var node = map(n)
      if (node.value != -1) {
        node.prev.next = node.next
        node.next.prev = node.prev
      }
      node.value = -1
    }
  }

  def showFirstUnique(): Int = head.next.value

  def add(value: Int): Unit = {
    if (!map.contains(value)) {
      var node = new Node()
      node.value = value
      map.put(value, node)
      node.prev = tail.prev
      tail.prev = node
      node.prev.next = node
      node.next = tail
    }
    else {
      var node = map(value)
      if (node.value != -1) {
        node.prev.next = node.next
        node.next.prev = node.prev
      }
    }
  }
}

class Node {
  var value = 0
  var next: Node = _
  var prev: Node = _
}
