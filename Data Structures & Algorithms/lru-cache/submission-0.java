class LRUCache {

    // Node definition for Doubly Linked List
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private java.util.Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new java.util.HashMap<>();
        
        // Initialize dummy head and tail nodes to avoid null checks during edge cases
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Mark as recently used by moving it to the tail
        remove(node);
        insertToTail(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing value and move to tail
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToTail(node);
        } else {
            // Check capacity limit
            if (map.size() == capacity) {
                // Evict the least recently used item (the one right after head)
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            
            // Create a new node and add it to the tail
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToTail(newNode);
        }
    }

    // Helper method to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right before the tail (making it most recently used)
    private void insertToTail(Node node) {
        Node prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }
}