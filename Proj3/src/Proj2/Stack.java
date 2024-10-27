package Proj2;

public class Stack {
    final static int SIZE = 4000;
    Object[] stack;
    int top = -1;


    public Stack() {
        this(SIZE);
    }

    public Stack(int size) {
        stack = new Object[size];

    }

    public boolean isFull() {
        return top == SIZE - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean push(Object obj) {
        if (isFull())
            return false;
        top ++ ;
        stack[top] = obj;
        return true;
    }

    public Object pop() {
        if (isEmpty())
            return null;
        return stack[top--];
    }

    public Object peek() {
        if (isEmpty())
            return (Character) null;
        return  stack[top];
    }

    public void sortStack() {
        if (!isEmpty()) {
            Object[] temp = new Object[top + 1];
            int i = 0;
            while (!isEmpty()) {
                temp[i++] = pop();
            }
            java.util.Arrays.sort(temp);
            for (Object item : temp) {
                push(item);
            }
        }
    }

    public void insertIntoSortedStack(Object obj) {
        if (isEmpty()) {
            push(obj);
            return;
        }
        Stack tempStack = new Stack(top + 1);
        while (!isEmpty() && (int) peek() < (int) obj) {
            tempStack.push(pop());
        }
        push(obj);
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    public int getSize() {
        return SIZE;
    }

    public static Stack mergeSortedStacks(Stack stack1, Stack stack2) {
        Stack mergedStack = new Stack(stack1.getSize() + stack2.getSize());
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if ((int) stack1.peek() <= (int) stack2.peek()) {
                mergedStack.push(stack1.pop());
            } else {
                mergedStack.push(stack2.pop());
            }
        }
        while (!stack1.isEmpty()) {
            mergedStack.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            mergedStack.push(stack2.pop());
        }
        return mergedStack;
    }
    public boolean areBracketsBalanced(String expr) {
        Stack stack = new Stack();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char check;
            switch (x) {
                case ')':
                    check = (char) stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = (char) stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = (char) stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();

        ////////////////////////////////////

    }
    private int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    private char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L';
    }
    public String infixToPostfix(String s) {
        String result = "";
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result += c;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && ((char)stack.peek() != '(')) {
                    result += stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && (prec(s.charAt(i)) < prec((char) stack.peek()) ||
                        prec(s.charAt(i)) == prec((char) stack.peek()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
