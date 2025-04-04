package doit.basic.queue;

import java.util.Scanner;

public class IntQueue {
    private int max; // 큐의 용량: 큐에 저장할 수 있는 최대 요소의 개수
    private int front; // 첫 번째 요소 커서
    private int rear; // 마지막 요소 커서
    private int num; // 현재 데이터 수: front와 rear의 값이 같을 때 상태 구분
    private int[] queue; // 큐 본체

    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            queue = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int offer(int x) throws OverflowIntQueueException {
        if(isFull()) {
            throw new OverflowIntQueueException();
        }

        queue[rear++] = x; // 큐의 마지막 요소로 저장
        num++; // 데이터 수 증가

        if(rear == max) { // 배열의 용량과 마지막 커서가 같은 경우 0으로 변경
            rear = 0;
        }

        return x;
    }

    // 큐에서 데이터를 디큐
    public int poll() throws EmptyIntQueueException {
        if(isEmpty()) {
            throw new EmptyIntQueueException();
        }

        int x = queue[front++]; // 큐의 첫 번째 요소
        num--; // 현재 데이터 수 감소

        if(front == max) { // 첫 번째 요소 커서가 배열의 길이와 같으면 0
            front = 0;
        }

        return x; // 첫 번째 요소 반환
    }

    // 큐에서 데이터를 피크(첫 번째 요소 엿보기)
    public int peek() throws EmptyIntQueueException {
        if(isEmpty()) {
            throw new EmptyIntQueueException();
        }
        return queue[front];
    }

    // 큐에서 x를 검색하여 인덱스 반환
    public int indexOf(int x) {
        for(int i=0; i< num; i++) {
            int idx = (i + front) % max;
            if(queue[idx] == x) {
                return idx;
            }
        }

        return -1;
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 용량 반환
    public int capacity() {
        return max;
    }

    // 데이터 수
    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if(isEmpty()) {
            System.out.println("queue is empty.");
        } else {
            for(int i=0; i<num; i++) {
                System.out.print(queue[(i+front) % max] + " ");
            }
            System.out.println();
        }
    }

    public int search(int x) {
        for(int i=0; i< num; i++) {
            int idx = (i + front) % max;
            if(queue[idx] == x) {
                return i + 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("큐의 크기: ");
        int n = sc.nextInt();
        IntQueue q = new IntQueue(n);

        while(true) {
            System.out.println("==============================");
            System.out.println("현재 데이터 수: " + q.size() + " / " + q.capacity());
            System.out.print("1.오퍼 2.폴 3.피크 4.덤프 5.인덱스 6.비우기 7.검색 0.종료 > ");

            int menu = sc.nextInt();
            if(menu == 0) break;

            int x;
            switch(menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    try {
                        q.offer(x);
                    } catch (OverflowIntQueueException e) {
                        System.out.println("queue is full.");
                    }
                    break;

                case 2:

                    try {
                        x = q.poll();
                        System.out.println("poll " + x);
                    } catch (EmptyIntQueueException e) {
                        System.out.println("queue is empty.");
                    }
                    break;

                case 3:
                    try {
                        x = q.peek();
                        System.out.println("peek " + x);
                    } catch (EmptyIntQueueException e) {
                        System.out.println("queue is empty.");
                    }
                    break;

                case 4:
                    q.dump();
                    break;

                case 5:
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    int index = q.indexOf(x) + 1;

                    if(index > 0) {
                        System.out.println("인덱스: " + index);
                    } else {
                        System.out.println(x + "은(는) 존재하지 않습니다.");
                    }
                    break;

                case 6:
                    q.clear();
                    break;

                case 7:
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    int search = q.search(x);

                    if(search > 0) {
                        System.out.println("순서: " + search);
                    } else {
                        System.out.println(x + "은(는) 존재하지 않습니다.");
                    }
                    break;
            }
        }
    }
}
