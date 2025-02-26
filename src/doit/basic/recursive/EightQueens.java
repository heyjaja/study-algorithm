package basic.recursive;

public class EightQueens {
    // 서로를 공격하여 잡을 수 없도록 8개의 퀸을 8x8 체스판에 놓기

    static int[] pos = new int[8]; // 각 열의 퀸의 위치
    static boolean[] flagA = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static boolean[] flagB = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flagC = new boolean[15]; // \ 대각선 방향으로 퀸을 배치했는지 체크
    static int count = 1;

    static void print() {
        System.out.println("---" + count++ + "---");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(pos[i] == j) {
                    System.out.print("X");
                    continue;
                }
                System.out.print("O");
            }
            System.out.println();
        }
    }

    // 각 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열
    static void set1(int i) { // i열에 퀸을 놓기
        for (int j = 0; j < 8; j++) {
            pos[i] = j; // 퀸을 j행에 배치
            if(i == 7) { // 모든 열에 배치
                print();
            } else {
                set1(i + 1); // 다음 열에 퀸 배치
            }
        }
    }

    // 각 행, 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열
    static void set2(int i) { // i열 알맞은 위치에 퀸을 배치
        for (int j = 0; j < 8; j++) {
            if(flagA[j] == false) { // j행에 퀸을 아직 배치하지 않았다면
                pos[i] = j; // 퀸을 j에 배치
                if(i == 7) { // 모든 열에 배치한 경우
                    print();
                } else {
                    flagA[j] = true;
                    set2(i + 1);
                    flagA[j] = false;
                }
            }
        }
    }

    static void set3(int i) { // i열 알맞은 위치에 퀸을 배치
        for (int j = 0; j < 8; j++) {
            if(flagA[j] == false // j행 배치 여부 확인
                    && flagB[i + j] == false // 대각선 / 배치 여부 확인
                    && flagC[i - j + 7] == false) { // 대각선 \ 배치 여부 확인
                pos[i] = j; // 퀸을 j에 배치
                if(i == 7) { // 모든 열에 배치한 경우
                    print();
                } else {
                    flagA[j] = flagB[i + j] = flagC[i - j + 7] = true;
                    set3(i + 1);
                    flagA[j] = flagB[i + j] = flagC[i - j + 7] = false;
                }
            }
        }
    }

    // 8퀸 문제를 비재귀적으로 구현하기
    static void set4(int i) {

    }

    public static void main(String[] args) {
        set3(0); // 0열에 퀸을 배치
    }

}
