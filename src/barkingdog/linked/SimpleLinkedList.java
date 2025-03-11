package barkingdog.linked;

import java.util.Arrays;

public class SimpleLinkedList {
    // 야매 연결 리스트
    final int max = 1000005;
    int[] data = new int[max]; // 원소의 값
    int[] prev = new int[max]; // 이전 원소의 인덱스
    int[] next = new int[max]; // 다음 원소의 인덱스
    int unused = 1; // 새로 원소가 들어갈 수 있는 인덱스

    public SimpleLinkedList() {
        // 0번지(인덱스 0)에는 -1, -1, 첫번째 요소 인덱스를 저장하여 이전 원소가 존재하지 않음을 저장
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
    }

    void traverse() {
        int cur = next[0];
        while(cur != -1) {
            System.out.print(data[cur]+" ");
            cur = next[cur];
        }
        System.out.println();
    }

    void insert(int addr, int num) {
        data[unused] = num; // 1. 새로운 원소를 생성
        prev[unused] = addr; // 2. 새 원소의 prev 값에 삽입할 위치의 주소 대입
        next[unused] = next[addr]; // 3. 새 원소의 next 값에 삽입합 위치의 next 값 대입
        if(next[addr] != -1) prev[next[addr]] = unused; // 4. 삽입할 위치 다음 원소의 prev 값을 새 원소로 변경
        next[addr] = unused; // 삽입할 위치의 next 값을 새 원소로 변경
        unused++; // 5. unused 1 증가
    }

    void erase(int addr) {
        // 이전 위치의 next 값을 삭제할 원소의 next 값으로 변경
        next[prev[addr]] = next[addr];
        // 다음 위치의 prev 값을 삭제할 원소의 prev 값으로 변경
        if(next[addr] != -1) prev[next[addr]] = prev[addr];
    }
}
