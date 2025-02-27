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
                System.out.print(pos[i] == j ? "X" : "O");
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

    // 비재귀적으로 8퀸 문제 해결 (반복적 백트래킹)
    static void set8Iterative(int i) {
        while (i >= 0) { // i == 현재 처리할 열
            if (pos[i] < 8) { // i열에서 아직 확인하지 않은 후보 행이 있다면
                int j = pos[i]; // j: 현재 i열에 놓을 후보 행
                // 해당 행과 양쪽 대각선에 이미 퀸이 없으면 배치 가능
                if (!flagA[j] && !flagB[i + j] && !flagC[i - j + 7]) {
                    // 퀸을 (i, j)에 배치하므로 플래그들을 업데이트
                    flagA[j] = true;
                    flagB[i + j] = true;
                    flagC[i - j + 7] = true;
                    pos[i] = j;  // i열의 퀸 위치를 저장

                    if (i == 7) {
                        // 마지막 열까지 배치한 경우 해를 찾음
                        print();
                        // 해를 출력한 후, 현재 열(i=7)의 퀸을 제거하고 다음 후보를 찾기 위해 pos[i]를 증가
                        flagA[j] = false;
                        flagB[i + j] = false;
                        flagC[i - j + 7] = false;
                        pos[i]++;
                    } else {
                        // i열에 퀸을 배치했으므로 다음 열로 진행
                        i++;
                        pos[i] = 0; // 다음 열의 후보 행은 0부터 시작
                    }
                } else {
                    // (i, j) 위치에 배치할 수 없으므로, 같은 열에서 다음 행을 시도
                    pos[i]++;
                }
            } else {
                // i열의 모든 행(0~7)을 시도했으나 배치할 수 없으므로 백트래킹 수행
                pos[i] = 0; // i열의 후보 행 포인터를 초기화
                i--;        // 바로 이전 열로 돌아감
                if (i >= 0) {
                    // 이전 열에 배치된 퀸을 제거한 후, 그 열에서 다음 후보 행을 시도하도록 준비
                    int prevRow = pos[i];
                    flagA[prevRow] = false;
                    flagB[i + prevRow] = false;
                    flagC[i - prevRow + 7] = false;
                    pos[i]++; // 이전 열에서 다음 후보 행으로 이동
                }
            }
        }
    }

    public static void main(String[] args) {
        set8Iterative(0); // 0열에 퀸을 배치
    }

}
