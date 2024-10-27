package Proj1;

public class Queue {
    private int front, rear;
    private Object [] queue;
    private final static int SIZE=25;
    private int size;

    public int getFront() {
        return front;
    }
    public int getRear() {
        return rear;
    }
    public Object[] getQueue() {
        return queue;
    }
    public int getSize() {
        return size;
    }
    Queue(){
        this(SIZE);
    }
    public Queue(int size2) {
        size=size2;
        front =rear=-1;
        queue=new Object[size2];
    }
    public int nextRear() {
        if (rear==size-1) {
            rear=0;
        }
        return ++rear;

    }
    public boolean isEmpty() {
        if(front==rear) {
            return true;
        }
        return false;

    }
    public boolean isFull() {
        if (nextRear()==front) {
            return true;
        }
        return false;
    }

   public void Enqueue(Object data)
    {
        if (size == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }

        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }

    public void Dequeue()
    {
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            if (rear < size)
                queue[rear] = 0;
            rear--;
        }
        return;
    }
    public Object peek() {
        if (isEmpty())
            return (Character) null;
        return (char) queue[front];
    }
    public void Display()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }
    public void Front()
    {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d",
                queue[front]);
        return;
    }
}
