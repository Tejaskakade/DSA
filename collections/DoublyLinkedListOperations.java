
public class DoublyLinkedListOperations {

    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head; // head of the doubly linked list

    // 1) Add node at the beginning
    public void addNodeAtFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2) Add node at the end
    public void addNodeAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    // 3) Print nodes
    public void printNode() {
        if (head == null) {
            System.out.println("Node list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " <=> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    // 4) Delete the first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("First node deleted: " + head.val);
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // 5) Delete the last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            System.out.println("Last node deleted: " + head.val);
            head = null;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        System.out.println("Last node deleted: " + currentNode.val);
        currentNode.prev.next = null;
    }

    // 6) Insert at a specific index
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
        while (currentNode != null && currentIndex < index - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        
        // If currentNode is null, the index is out of bounds
        if (currentNode == null) {
            System.out.println("Index out of bounds");
            return;
        }

        // Insert the new node
        newNode.next = currentNode.next;
        newNode.prev = currentNode;

        if (currentNode.next != null) {
            currentNode.next.prev = newNode;
        }
        currentNode.next = newNode;
    }

    // 7) Size of the list
    public void lengthOfList() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        System.out.println("Size of the list is: " + count);
    }

    public static void main(String[] args) {
        DoublyLinkedListOperations list = new DoublyLinkedListOperations();
        list.addNodeAtFirst(1);
        list.addNodeAtLast(2);
        list.addNodeAtLast(3);
        list.addNodeAtLast(4);
        list.addNodeAtLast(5);
        list.addNodeAtLast(6);

        // Print the initial list
        System.out.println("Initial Doubly Linked List:");
        list.printNode();

        // Insert a new node at a specific index
        list.insertAtIndex(3, 10); // Insert 10 at index 3 (0-based index)

        // Print the modified list
        System.out.println("Doubly Linked List after insertion:");
        list.printNode();

        // Check length
        list.lengthOfList();
    }
}
