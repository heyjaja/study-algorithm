package barkingdog.stack;

public class SimpleStack {
    final int MX = 1000005;
    int[] data = new int[MX];
    int pos = 0;

    void push(int x) {
        data[pos++] = x;
    }

    void pop() {
        pos--;
    }

    int top() {
        return data[pos-1];
    }
}
