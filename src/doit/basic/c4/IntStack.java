package basic.c4;

import java.util.Scanner;

public class IntStack {
    private int max; // 스택 용량: 최대 데이터 수
    private int ptr; // 스택 포인터: 쌓여 있는 데이터의 수
    private int[] stk; // 스택 본체용 배열

    // 생성자: 스택용 배열 생성
    public IntStack(int capacity) {
        ptr = 0; // 스택이 비어있음
        max = capacity; // 배열의 길이 == 용량
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) { // 존재하지 않는 배열에 접근하는 것을 막음
            max = 0;
        }
    }

    // 스택에 데이터를 저장하고 저장한 값을 반환
    public int push(int x) throws OverflowStackException {
        if(ptr >= max) { // 스택이 가득 찼을 때 에러 발생
            throw new OverflowStackException();
        }
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 제거하고 그 값을 반환
    public int pop() throws EmptyStackException {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }

        return stk[--ptr];
    }

    // 스택의 데이터를 제거 없이 반환
    public int peek() throws EmptyStackException {
        if(ptr <= 0) {
            throw new EmptyStackException();
        }

        return stk[ptr - 1];
    }

    // 검색: top -> bottom 선형 검색 첫번째 요소의 인덱스 반환
    public int indexOf(int x) {
        for(int i = ptr - 1; i >= 0; i--) {
            if(stk[i] == x) {
                return i;
            }
        }

        return -1; // 존재하지 않는 값 -1 반환
    }

    // 스택의 모든 요소 삭제
    public void clear() {
        ptr = 0;
    }

    // 스택의 용량 확인
    public int capacity() {
        return max;
    }

    // 현재 쌓인 데이터 수 확인
    public int size() {
        return ptr;
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는지 확인
    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 bottom -> top 순서로 출력
    public void dump() {
        if(isEmpty()) {
            System.out.println("stack is empty.");
            return;
        }
        for (int i = 0; i < ptr; i++) {
            System.out.print(stk[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("스택의 크기: ");
        int n = sc.nextInt();
        IntStack s = new IntStack(n);

        while(true) {
            System.out.println("==============================");
            System.out.println("현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.print("1.푸시 2.팝 3.피크 4.덤프 0.종료 > ");

            int menu = sc.nextInt();
            if(menu == 0) break;

            int x;
            switch(menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = sc.nextInt();
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
            }
        }
    }
}
