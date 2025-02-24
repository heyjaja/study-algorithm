package basic.recursive;

import java.util.Scanner;

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
    }

    private static void move(int n, int x, int y) {
        // 기둥 번호를 정수 1,2,3으로 표현하여 목표 기둥이 어느 기둥이라도 중간기둥을 6-x-y로 구할 수 있다
        if(n > 1) {
            move(n - 1, x, 10-x-y);
        }
        System.out.println("원반[" + x + "]: " + x + "->" + y);

        if(n > 1) {
            move(n - 1, 10-x-y, y);
        }
    }

    private static void move2(int n, int x, int y) {
        // move를 비재귀적으로 구현하기
    }
}
