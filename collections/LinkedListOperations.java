
public class LinkedListOperations {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head; // created a head node

    // 1) add node at first
    public void addNodeAtFirst(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 2) add node at last

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
    }

    // 3) Print Node
    public void printNode() {
        if (head == null) {
            System.out.println("Node list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + "=> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // 4) delete First node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty :");
            return;
        }
        System.out.println(" First Node is deleted");
        head = head.next;

    }

    // 5) Delete Last Node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty :");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node lastNode = head.next;
        Node secondLast = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;

        }
        secondLast.next = null;
    }

    // 6)  Size of the list
    public void lengthOfList(){
        int count=0;
        Node currentNode=head;
        while(currentNode != null){
            currentNode = currentNode.next;
            count++;
        }
        System.out.println("Size of the  list  is : " + count);
    }

    // 7) delete elemenet at specific  position from last

    public  void deleteFromLastIndex(int n){
        int size= 0;
        Node current=head;
        while(current != null){
            current=current.next;
            size++;
        }
        int elementIndex= (size-n)+1;
        int previousIndex=elementIndex-1;

        current=head;
        int i=1;
        while(i <previousIndex){
            current=current.next;
            i++;
        }
        current.next=current.next.next;

    }

    // 8) Insert at Specific Index
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
    currentNode.next = newNode;
}
    public static void main(String[] args) {

        LinkedListOperations list = new LinkedListOperations();
        list.addNodeAtFirst(1);
        list.addNodeAtLast(2);
        list.addNodeAtLast(3);
        list.addNodeAtLast(4);
         list.printNode();
         list.deleteFirst();
         list.printNode();
         list.deleteLast();
        list.addNodeAtLast(5);
        list.addNodeAtLast(6);
        list.printNode();
        list.lengthOfList();

        list.deleteFromLastIndex( 2);
        list.printNode();

    }

}

