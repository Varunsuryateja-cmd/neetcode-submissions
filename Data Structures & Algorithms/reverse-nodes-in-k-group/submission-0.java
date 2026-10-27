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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Create a dummy node to easily handle head pointer updates
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // 1. Find the k-th node from the current groupPrev
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break; // Fewer than k nodes left, leave them as they are
            }
            ListNode groupNext = kth.next;

            // 2. Reverse the k-group
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            
            while (curr != groupNext) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // 3. Connect the reversed group with the rest of the list
            ListNode temporary = groupPrev.next; // This becomes the tail of the reversed group
            groupPrev.next = kth;               // Connect previous group's tail to the new group head
            groupPrev = temporary;              // Move groupPrev to the tail of the current group
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
