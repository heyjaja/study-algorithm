package basic.recursive;

import basic.stack.IntStack;

import java.util.Scanner;

public class Recur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        System.out.println("recur()");
        recur(x);
        System.out.println("\nrecur2()");
        recur2(x);
        System.out.println("\nrecur3()");
        recur3(x);
        System.out.println("\nrecur4()");
        recur4(x);
        System.out.println("\nrecur5()");
        recur5(x);
        System.out.println("\nrecur6()");
        recur6(x);
    }

    private static void recur(int n) {
        // n이 4일 때
        if(n > 0) {
            recur(n - 1); // recur(3) 호출
            System.out.print(n + " "); // 4 출력
            recur(n - 2); // recur(2) 호출
        }
    }

    private static void recur2(int n) {
        if(n > 0) {
            recur(n - 2);
            System.out.print(n + " ");
            recur(n - 1);
        }
    }

    private static void recur3(int n) {
        // recur 메서드를 비재귀로 표현하기 -> 꼬리 재귀 제거
        while(n > 0) {
            recur3(n-1);
            System.out.print(n + " ");
            n = n - 2; // 처음으로 돌아가 recur3(n-2)를 호출한 효과
        }
    }

    private static void recur4(int n) {
        IntStack stack = new IntStack(n);
        while(true) {
            if(n > 0) { // 4->3->2->1 순서로 쌓인 stack 4->1 2->1
                stack.push(n); // n과 n - 1 값을 저장
                n = n-1;
                continue;
            }
            if(!stack.isEmpty()) { // 4->3->2 1 pop! 4->3 2 pop! 4 3 pop!, 4 1 pop! 4 pop!, 2 1 pop! 2 pop!
                n = stack.pop(); // n <= 0이 되면 저장한 n 값을 pop
                System.out.print(n + " ");
                n = n-2; // n-2 값을 다시 stack에 저장
                continue;
            }
            break;
        }
    }

    private static void recur5(int n) {
        if(n>0) {
            recur5(n-1);
            recur5(n-2);
            System.out.print(n + " ");
        }
    }

    private static void recur6(int n) {
        // recur5를 비재귀적으로 구현하기
    }
}
