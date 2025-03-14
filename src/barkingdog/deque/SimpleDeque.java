package barkingdog.deque;

public class SimpleDeque {
    final int MX = 1000005;
    int[] data = new int[2*MX+1]; // 중간 값으로 초기화 하기 위해서 배열의 크기를 MX*2+1로 설정
    int head = MX, tail = MX; // 양쪽으로 확장이 필요하기 때문에 배열의 중간 값으로 head와 tail을 초기화

    void pushFront(int x) {
        data[--head] = x;
    }

    void pushBack(int x) {
        data[tail++] = x;
    }

    void popFront() {
        head++;
    }

    void popBack() {
        tail--;
    }

    int front() {
        return data[head];
    }

    int back() {
        return data[tail - 1];
    }

}
