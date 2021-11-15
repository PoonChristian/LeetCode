// LeetCode 138: Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/

// Algorithm: In the first pass, use a HashMap to map the original node to its deep copy without any links to the next and randoms
//            In the second pass, get the deep copy and assign its next and random pointers to its corresponding deep copies in the map

// Reason: The random pointer poses problems because it can point to any part of the list, and we have no guarantee where it will point to
//         This makes it difficult to create a deep copy of it in the first pass since a random pointer can point to a node we haven't made a deep copy for yet
//         By using a HashMap, we can simply create all the nodes first, and then have easy O(1) access to each copied node in the second pass
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node curr = head;
        
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        
        while (curr != null) {
            // map.get() will return null if the key doesn't exist, so this code handles null next and random pointers as well
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        // Return the deep copy associated with the head
        return map.get(head);
    }
}