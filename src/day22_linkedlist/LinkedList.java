package day22_linkedlist;

public class LinkedList {
    // Node class represents each element in the LinkedList
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data; // Store data
            this.next = null; // Next is null initially
        }
    }

    public static Node head; // Head of the LinkedList
    public static Node tail; // Tail of the LinkedList
    public static int size = 0; // Size of the LinkedList

    // Add a new node at the beginning of the LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data); // Create a new node
        size++; // Increment size
        if (head == null) {
            // If list is empty, head and tail are the new node
            head = tail = newNode;
            return;
        }
        newNode.next = head; // Link new node to the current head
        head = newNode; // Update head
    }

    // Add a new node at the end of the LinkedList
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        size++; // Increment size
        if (head == null) {
            // If list is empty, head and tail are the new node
            head = tail = newNode;
            return;
        }
        tail.next = newNode; // Link tail to the new node
        tail = newNode; // Update tail
    }

    // Print all elements of the LinkedList
    public void print() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->"); // Print each node's data
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add a node at a specific index
    public void add(int ind, int data) {
        if (ind == 0) {
            addFirst(data); // If index is 0, add at the start
            return;
        }
        Node newNode = new Node(data); // Create a new node
        size++; // Increment size
        Node temp = head;
        int i = 0;
        while (i < ind - 1) { // Traverse to the (index - 1)th node
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next; // Link newNode to next node
        temp.next = newNode; // Link previous node to newNode
    }

    // Remove the first node
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null; // Clear the list
            size = 0;
            return val;
        }
        int val = head.data; // Store data of the head
        head = head.next; // Move head to the next node
        size--;
        return val;
    }

    // Remove the last node
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null; // Clear the list
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) { // Traverse to the second last node
            prev = prev.next;
        }
        int val = prev.next.data; // Store tail's data
        prev.next = null; // Remove the last node
        tail = prev; // Update tail
        size--;
        return val;
    }

    // Search for an element iteratively
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i; // Return index if key is found
            }
            temp = temp.next;
            i++;
        }
        return -1; // Key not found
    }

    // Reverse the LinkedList
    public void reverse() {
        Node prev = null;
        Node curr = tail = head; // Start with head
        Node next;
        while (curr != null) {
            next = curr.next; // Save the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev forward
            curr = next; // Move curr forward
        }
        head = prev; // Update head
    }

    // Delete the nth node from the end
    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++; // Calculate size
        }
        if (n == sz) {
            head = head.next; // Remove the first node
            return;
        }
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; // Skip the nth node
    }

    // Find the middle node using the slow-fast pointer approach
    public Node findMid(Node Head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }
        return slow; // Slow will point to the middle
    }

    // Check if the LinkedList is a palindrome
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty or single node list is a palindrome
        }
        Node midleNode = findMid(head); // Find the middle node

        // Reverse the second half
        Node prev = null;
        Node curr = midleNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // Right half head
        Node left = head;

        // Compare left and right halves
        while (right != null) {
            if (left.data != right.data) {
                return false; // Mismatch found
            }
            left = left.next;
            right = right.next;
        }
        return true; // List is a palindrome
    }

    // Check if the LinkedList contains a cycle
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow one step
            fast = fast.next.next; // Move fast two steps
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // Uncomment below line to create a cycle
        // head.next.next.next = head;
        // 1->2->3->1
        System.out.println(isCycle());
    }
}
