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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Start with new node as we might have to delete the lastnode
        ListNode slow = new ListNode();
        //Solution will be ans.next
        ListNode ans = slow;
        slow.next = head;
        ListNode fast = head;
        //Reach till the difference of n so that when fast reaches end we know which node to skip
        int i = 1;
        while(i<=n-1){
            fast = fast.next;
            i++;
        }
        //Reach till end of the List
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the value
        slow.next = slow.next.next;
        return ans.next;
    }
}
