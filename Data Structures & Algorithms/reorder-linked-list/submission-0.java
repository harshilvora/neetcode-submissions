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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse from next node after midpoint to get the correct order
        ListNode reverse = slow.next;
        //Break the second half from first
        slow.next = null;
        ListNode prev = null;
        //Reverse logic
        while (reverse != null) {
            ListNode temp = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = temp;
        }
        //Merge both parts
        ListNode ans = head;
        reverse = prev;
        while (reverse != null) {
            //Temporarily store the next pointers
            ListNode temp1 = ans.next;
            ListNode temp2 = reverse.next;
            //Reorder the list
            ans.next = reverse;
            reverse.next = temp1;
            //Go to the next node for next iteration
            ans = temp1;
            reverse = temp2;
        }
    }
}
