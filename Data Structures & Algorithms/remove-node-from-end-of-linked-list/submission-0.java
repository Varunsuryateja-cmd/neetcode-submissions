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
        // Create a dummy node to handle edge cases easily (e.g., removing the head)
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n + 1 steps ahead so the gap between slow and fast is n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}