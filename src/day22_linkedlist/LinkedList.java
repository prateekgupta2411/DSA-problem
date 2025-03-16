package day22_linkedlist;

public class LinkedList {
    // Node class
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

    // Add First
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print LL
    public void print() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add a node at any index
    public void add(int ind, int data) {
        if (ind == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < ind - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first element
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove last element
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // remove the nth node
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

    // Search
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Reverse the LinkedList
    public void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next; // Save the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev forward
            curr = next; // Move curr forward
        }
        head = prev; // Update head
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
        // head.next.next.next = head;
        // 1->2->3->1
        System.out.println(isCycle());
    }
}
