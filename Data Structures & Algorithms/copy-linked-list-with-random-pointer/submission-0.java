/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // HashMap to map original nodes to their corresponding copied nodes
        HashMap<Node, Node> map = new HashMap<>();
        
        // First pass: Create all copied nodes and store them in the hash map
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // Second pass: Assign next and random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        
        // Return the head of the cloned list
        return map.get(head);
    }
}