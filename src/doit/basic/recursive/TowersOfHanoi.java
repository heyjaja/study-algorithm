package basic.recursive;

import java.util.Scanner;
import java.util.Stack;

public class TowersOfHanoi {
    // 하노이의 탑
    // 목표 기둥으로 원반을 옮긴다
    // 그룹을 지어 옮길 수 있고, 작은 원반 위에 큰 원반이 위치할 수 없다
    // 목표 기둥으로 원반을 옮기는 데 몇번을 옮겨야 하는지 구하기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원반 개수: ");
        int n = sc.nextInt();

        move(n, 1, 3); // 1번 기둥의 n개의 원반을 3번 기둥으로 옮기기
        move2(n, 1, 3); // 1번 기둥의 n개의 원반을 3번 기둥으로 옮기기
    }

    private static void move(int n, int x, int y) {
        // 기둥 번호를 정수 1,2,3으로 표현하여 목표 기둥이 어느 기둥이라도 중간기둥을 6-x-y로 구할 수 있다
        if(n > 1) {
            move(n - 1, x, 6-x-y);
        }
        System.out.println("원반[" + n + "]: " + x + "->" + y);

        if(n > 1) {
            move(n - 1, 6-x-y, y);
        }
    }

    private static void move2(int n, int x, int y) {
        // move를 비재귀적으로 구현하기
        Stack<Step> stack = new Stack<>();
        stack.push(new Step(n, x, y, 0)); // 전체 원반에 대한 재귀 실행

        while(!stack.empty()) {
            Step pop = stack.pop();

            if(pop.step == 1) { // 이동(출력) 플래그
                System.out.printf("%d: %d->%d\n", pop.n, pop.from, pop.to);
            } else if(pop.n == 1) { // 원반 개수가 1 -> 바로 이동(출력)
                System.out.printf("%d: %d->%d\n", pop.n, pop.from, pop.to);
            } else if(pop.n > 1){ // 재귀 분해(후순위 실행 항목을 먼저 push)
                stack.push(new Step(pop.n - 1, pop.getStop(), pop.to, 0));
                stack.push(new Step(pop.n, pop.from, pop.to, 1));
                stack.push(new Step(pop.n - 1, pop.from, pop.getStop(), 0));

            }
        }
    }

    static class Step{
        int n; // 처리할 원반 개수 혹은 번호
        int from; // 이동 시작 기둥
        int to; // 이동 도착 기둥
        int step; // 1이면 이동(출력), 0이면 재귀 진행

        public Step(int n, int from, int to, int step) {
            this.n = n;
            this.from = from;
            this.to = to;
            this.step = step;
        }

        public int getStop() {
            return 6-to-from;
        }
    }
}
