//Doubly Linked List Data Structure
public class Node {
    //k,v
    int key;
    int val;
    //prev and next pointer
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {

    //map is the actual cache
    HashMap<Integer, Node> map;
    //The most recently used value will be left.next
    Node left;
    //The least recently used value will be prev.next
    Node right;
    //To track total capacity of cache
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        //Initially there will be just the ends of the cache pointing to each other
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        // null <- left <-> right -> null
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    //Get - O(1)
    public int get(int key) {
        //If map contains key
        if(map.containsKey(key)){
            Node node = map.get(key);
            //remove the node at the position its in 
            remove(node);
            //move it to the front as its most recently used
            insertAtFront(node);
            return node.val;
        }
        //Default response
        return -1;
    }

    //Put - O(1)
    public void put(int key, int value) {
        //If map has key
        if (map.containsKey(key)) {
            //remove the key as we are inserting later by default
            remove(map.get(key));
            map.remove(key);
        }
        //Insert new node to the front of the cache as its recently used
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtFront(newNode);
        //After inserting if we are over capacity
        if (map.size() > cap) {
            // remove the least recently used, i.e. right.prev
            Node lru = right.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    //Remove logic
    private void remove(Node cur) {
        //swap the prev and next pointers of the next and prev of the current node
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    //InsertAtFront of the cache logic, i.e. most recently used
    private void insertAtFront(Node newNode) {
        //Swap the next pointers and previos pointers accordingly with left
        Node next = left.next;
        next.prev = newNode;
        newNode.prev = left;
        newNode.next = next;
        left.next = newNode;
    }
}
