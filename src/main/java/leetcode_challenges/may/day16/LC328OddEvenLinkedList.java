package leetcode_challenges.may.day16;

public class LC328OddEvenLinkedList {
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
    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode evenHeader = head.next;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode current = evenHeader.next;
        int i = 1;
        while (current != null) {
            if (i % 2 != 0) {
                odd.next = current;
                odd = current;
            } else {
                even.next = current;
                even = current;
            }
            current = current.next;
            i++;
        }
        even.next = null;
        odd.next = evenHeader;
        return head;
    }
}
