package leetcode_challenges.may.day16

import leetcode_challenges.may.day16.LC328_OddEvenLinkedList.Helpers.ListNode

object LC328_OddEvenLinkedList {

  //    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
  //
  //    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
  //
  //    Example 1:
  //
  //    Input: 1->2->3->4->5->NULL
  //    Output: 1->3->5->2->4->NULL
  //    Example 2:
  //
  //    Input: 2->1->3->5->6->4->7->NULL
  //    Output: 2->3->6->7->1->5->4->NULL
  object Helpers {

    class ListNode(_x: Int = 0, _next: ListNode = null) {
      var next: ListNode = _next
      var x: Int = _x
    }

    implicit def nodeToList(x: ListNode): List[Int] = {
      x match {
        case a if a == null => Nil
        case b if b != null => b.x :: nodeToList(b.next)
      }
    }

    implicit def listToNode(x: List[Int]): ListNode = {
      x match {
        case Nil => null
        case h :: t =>
          val head = new ListNode(h)
          head.next = listToNode(t)
          head
      }
    }
  }

  def oddEvenList(head: ListNode): ListNode = {

    val list = head.zipWithIndex.partition { case (_, b) => (b + 1) % 2 == 1 }
    list._1.map(_._1) ++ list._2.map(_._1)
  }
}
