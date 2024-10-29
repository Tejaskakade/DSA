
public class CircularLinkedListOperations {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head; // Reference to the head node

    // 1) Add node at first
    public void addNodeAtFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself to make it circular
            return;
        }

        Node tail = getTail();
        newNode.next = head;
        head = newNode;
        tail.next = head; // Maintain circular link
    }

    // 2) Add node at last
    public void addNodeAtLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular reference
            return;
        }

        Node tail = getTail();
        tail.next = newNode;
        newNode.next = head; // Circular link maintained
    }

    // Helper function to get the tail node
    private Node getTail() {
        Node currentNode = head;
        while (currentNode.next != head) { // Loop until we find the tail node
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // 3) Print the nodes in the circular linked list
    public void printNode() {
        if (head == null) {
            System.out.println("Node list is empty");
            return;
        }
        Node currentNode = head;
        do {
            System.out.print(currentNode.val + " => ");
            currentNode = currentNode.next;
        } while (currentNode != head);
        System.out.println();
    }

    // 4) Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node tail = getTail();

        if (head.next == head) { // Only one node in the list
            head = null;
        } else {
            head = head.next;
            tail.next = head; // Maintain circular link
        }

        System.out.println("First node is deleted");
    }

    // 5) Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) { // Only one node in the list
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != head) {
            current = current.next;
        }

        current.next = head; // Maintain circular link by pointing to head
    }

    // 6) Get the size of the list
    public void lengthOfList() {
        if (head == null) {
            System.out.println("Size of the list is: 0");
            return;
        }

        int count = 0;
        Node currentNode = head;
        do {
            count++;
            currentNode = currentNode.next;
        } while (currentNode != head);

        System.out.println("Size of the list is: " + count);
    }

    // 7) Delete node from a specific position from the last
    public void deleteFromLastIndex(int n) {
        int size = 0;
        Node current = head;
        do {
            size++;
            current = current.next;
        } while (current != head);

        int elementIndex = (size - n) + 1;
        int previousIndex = elementIndex - 1;

        current = head;
        int i = 1;
        while (i < previousIndex) {
            current = current.next;
            i++;
        }
        current.next = current.next.next;
    }

    // 8) Insert at a specific index
    public void insertAtIndex(int index, int value) {
        Node newNode = new Node(value);

        // If index is 0, add at the beginning
        if (index == 0) {
            addNodeAtFirst(value);
            return;
        }

        Node currentNode = head;
        int currentIndex = 0;

        // Traverse to the index just before the desired index
        while (currentNode.next != head && currentIndex < index - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        // If we reach the end of the list and index is out of bounds
        if (currentIndex < index - 1) {
            System.out.println("Index out of bounds");
            return;
        }

        // Insert the new node
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    public static void main(String[] args) {
        CircularLinkedListOperations list = new CircularLinkedListOperations();
        list.addNodeAtFirst(1);
        list.addNodeAtLast(2);
        list.addNodeAtLast(3);
        list.addNodeAtLast(4);

        list.printNode(); // Output: 1 => 2 => 3 => 4 =>

        list.deleteFirst();
        list.printNode(); // Output: 2 => 3 => 4 =>

        list.deleteLast();
        list.printNode(); // Output: 2 => 3 =>

        list.addNodeAtLast(5);
        list.addNodeAtLast(6);
        list.printNode(); // Output: 2 => 3 => 5 => 6 =>

        list.lengthOfList(); // Output: Size of the list is: 4

        list.deleteFromLastIndex(2); // Delete the second last element
        list.printNode(); // Output: 2 => 3 => 6 =>
        
        String str= "hii";
        StringBuffer str2=new StringBuffer("byy");
        
        System.out.println(str.concat("hello"));
        System.out.println(str2.append(str));

    }
}
