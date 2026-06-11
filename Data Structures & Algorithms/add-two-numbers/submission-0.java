/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recurseList(l1, l2, 0);
    }

    ListNode recurseList(ListNode l1, ListNode l2, int carry) {

        //If no more nodes and no carry then end of list
        if (l1 == null && l2 == null && carry == 0)
            return null;

        //Get values
        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        int value = (val1 + val2 + carry) % 10;
        //Calculate new carry
        carry = (val1 + val2 + carry) / 10;

        //keep traversing the list to get the next node value
        ListNode ans = recurseList(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);

        //back track all the way to reach the end and return the head of new list
        return new ListNode(value, ans);
    }
}
