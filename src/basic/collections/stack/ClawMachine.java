package basic.collections.stack;

import java.util.Scanner;
import java.util.Stack;

public class ClawMachine {
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i : moves) {
            for(int j=0; j<n; j++) {
                if(board[j][i-1] != 0) {
                    int doll = board[j][i-1];
                    if(!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    board[j][i-1] = 0;
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        // 인형뽑기
        // N * N board 안에 인형
        // 길이 M의 moves 배열: 인형을 뽑을 칸 숫자 배열
        // 바구니에 같은 인형이 담기면 터짐 -> 터진 인형의 수 출력
        ClawMachine main = new ClawMachine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];

        for(int i=0; i<m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, board, m, moves));
    }
}
