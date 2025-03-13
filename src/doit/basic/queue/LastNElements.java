package doit.basic.queue;

import java.util.Scanner;

public class LastNElements {
    static class RingBuffer {
        // 정해진 용량만큼 저장하고 꽉차면 오래된 데이터 제거 후 입력 데이터 계속 저장
        final int N = 10;
        int[] queue = new int[N];

        public int offer(int x, int count) {
            queue[count % N] = x;
            return x;
        }

        public void print(int count) {
            int i = Math.max(count - N, 0);

            for(; i<count; i++) {
                System.out.println((i+1) + " = " + queue[i % N]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RingBuffer rb = new RingBuffer();

        int count = 0, retry = 1;

        while(retry == 1) {
            System.out.print("입력: ");

            int x = sc.nextInt();
            rb.offer(x, count++);

            System.out.print("계속 입력하려면 1을 누르세요: ");
            retry = sc.nextInt();
        }

        rb.print(count);
    }
}
