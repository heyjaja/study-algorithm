import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] board;
    static int[][] boardR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        boardR = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0; // 최댓값
        for(int tmp = 0; tmp < 1024; tmp++) { // 5번 이동 4개 방향 => 4^5번
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    boardR[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i<5; i++) { // 5번 이동
                int dir = brute % 4; // 0~3까지 5자리 4진수로 표현하면 모든 경우의 수를 처리할 수 있음
                brute/=4;
                shift(dir);
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    max = Math.max(max, boardR[i][j]);
                }
            }
        }

        System.out.println(max);

    }

    private static void shift(int dir) {
        while(dir-- > 0) rotate(); // 0: 왼쪽 90: 아래 180: 오른쪽 270: 위 이동
        for(int i=0; i<n; i++) { // 왼쪽으로 이동하면서 같은 블럭일 때 한 번 *2
            int idx = 0;
            int[] shifted = new int[n];
            for(int j=0; j<n; j++) {
                int number = boardR[i][j];
                if(number == 0) continue;
                if(shifted[idx] == 0) {
                    shifted[idx] = number;
                } else if(shifted[idx] == number) {
                    shifted[idx++] *= 2;
                } else {
                    shifted[++idx] = number;
                }
            }
            for(int j=0; j<n; j++) {
                boardR[i][j] = shifted[j];
            }
        }
    }

    private static void rotate() {
        int[][] temp = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[i][j] = boardR[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boardR[i][j] = temp[n-1-j][i];
            }
        }
    }
}