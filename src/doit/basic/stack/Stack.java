package basic.stack;

import java.util.Objects;
import java.util.Scanner;

public class Stack<E> {
    private int max;
    private int ptr;
    private E[] stack;

    public Stack(int capacity) {
        ptr = 0;
        max = capacity;

        try {
            stack = (E[]) new Object[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
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
            if(stack[i].equals(e)) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("스택의 크기: ");
        int n = sc.nextInt();
        Stack<StackValue> s = new Stack<>(n);

        while(true) {
            System.out.println("==============================");
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("1.푸시 2.팝 3.피크 4.덤프 5.검색 6.비우기 0.종료 > ");

            int menu = sc.nextInt();
            if(menu == 0) break;

            StackValue x = new StackValue();
            switch(menu) {
                case 1:
                    System.out.print("이름: ");
                    x.name = sc.next();
                    System.out.print("나이: ");
                    x.age = sc.nextInt();
                    try {
                        s.push(x);
                    } catch (OverflowStackException e) {
                        System.out.println("stack is full.");
                    }
                    break;

                case 2:

                    try {
                        x = s.pop();
                        System.out.println("pop " + x);
                    } catch (EmptyStackException e) {
                        System.out.println("stack is empty.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("peek " + x);
                    } catch (EmptyStackException e) {
                        System.out.println("stack is empty.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("이름: ");
                    x.name = sc.next();
                    System.out.print("나이: ");
                    x.age = sc.nextInt();
                    int index = s.indexOf(x) + 1;

                    if(index > 0) {
                        System.out.println("위치: " + index);
                    } else {
                        System.out.println(x + "는 존재하지 않습니다.");
                    }
                    break;

                case 6:
                    s.clear();
                    break;
            }
        }
    }
    static class StackValue {
        String name;
        int age;

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StackValue that)) return false;
            return age == that.age && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
