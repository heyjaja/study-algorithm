package basic.c4;

public class Stack<E> {
    private int max;
    private int ptr;
    private E [] stack;

    public Stack(int capacity) {
        ptr = 0;
        max = capacity;
        stack = (E[]) new Object[capacity];
    }

    public E push(E e) throws OverflowStackException {
        if(isFull()) {
            throw new OverflowStackException();
        }
        return stack[ptr++] = e;
    }

    public E pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--ptr];
    }

    public E peek() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[ptr - 1];
    }

    public int indexOf(E e) {
        for(int i = 0; i < ptr; i++) {
            if(stack[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int size() {
        return ptr;
    }

    public int capacity() {
        return max;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public void dump() {
        if(isEmpty()) {
            System.out.println("stack is empty.");
            return;
        }
        for (int i = 0; i < ptr; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}
