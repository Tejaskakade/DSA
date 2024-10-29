
class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;


    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; 
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value; 
    }

   
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; 
        }
        return stackArray[top--]; 
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; 
        }
        return stackArray[top]; 
    }

    public boolean isFull() {
        return top == maxSize - 1; 
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1; 
    }
}

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack(5); 
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element is: " + stack.peek());
        
        System.out.println("Popped element is: " + stack.pop());
        
        stack.push(40);
        stack.push(50);
        stack.push(60); // Should be able to push as the stack is not full
        stack.push(70); // Should indicate that the stack is full

        // Display remaining elements
        System.out.println("Top element is: " + stack.peek());

        // Popping all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element is: " + stack.pop());
        }

        // Trying to pop from an empty stack
        stack.pop(); // Should indicate that the stack is empty
    }
}

