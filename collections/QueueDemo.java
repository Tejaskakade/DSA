
class Queue {
    private int[] queueArray; 
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) { 
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.size = 0;
        this.rear = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queueArray[rear] = item;
        size++;
        System.out.println("Enqueued: " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Indicating an error
        }
        int item = queueArray[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + item);

        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Indicating an error
        }
        return queueArray[front];
    }

  

    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }   
}
    
public class QueueDemo {
	
	public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of size 5
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This will indicate the queue is full
        queue.printQueue();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Current size: " + queue.getSize());
    }

}
