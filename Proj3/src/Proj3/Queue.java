package Proj3;



public class Queue {

    int front, rear;
    static int SIZE = 1000;
    TNode[] queue;
    int count = 0;


    public Queue() {
        this(SIZE);
    }

    public Queue(int size) {
        front = 0;
        rear = size - 1;
        this.queue = new TNode[size];
    }

    public boolean isEmpty() {

        return count == 0;

    }

    public boolean isFull() {

        return count == getSize();

    }

    public void enQueue(TNode data) {
        if (isFull()) {
            System.out.println("The Queue is Full !!!");
            return;
        } else {

            rear = (rear + 1) % getSize();
            queue[rear] = data;
            count++;

        }
    }

    public TNode deQueue() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty !!!");
            return null;
        }
        TNode temp = queue[front];
        front = (front + 1) % getSize();
        count--;
        return temp;
    }

    public int getSize() {
        return queue.length;
    }

    public Object getRear() {

        if (isEmpty()) {
            System.out.println("The Queue is Empty !!!");
            return null;
        }
        return queue[rear];
    }

    public TNode getFront() {

        if (isEmpty()) {
            System.out.println("The Queue is Empty !!!");
            return null;
        }

        return queue[front];
    }

    public TNode peek() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty !!!");
            return null;
        }
        return queue[rear];
    }

    public void printQueue(Queue q1) {
        Queue q2 = new Queue(q1.getSize());

        System.out.print("[ ");

        while (!q1.isEmpty()) {
            q2.enQueue(q1.deQueue());

            System.out.print(q2.peek() + " ");

        }

        System.out.print(" ]");
        System.out.println();

        while (!q2.isEmpty()) {
            q1.enQueue(q2.deQueue());


        }
    }

    public void printQueue() {
        System.out.print("[ ");

        int i = front;
        while (i != rear) {

            System.out.print(queue[i] + " ");

            i = (i + 1) % getSize();
        }
        System.out.print(queue[rear] + " ]");
        System.out.println();
    }
}
