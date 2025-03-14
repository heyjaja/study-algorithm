package barkingdog.queue;

public class SimpleQueue {
    final int MX = 1000005;
    int[] data = new int[MX];
    int head = 0, tail = 0;

    void push(int x) {
        data[tail++] = x;
    }

    void pop() {
        head++;
    }

    int front() {
        return data[head];
    }

    int back() {
        return data[tail - 1];
    }
}
