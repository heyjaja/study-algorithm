package array;

import java.util.Scanner;

public class RockPaperScissors {

    public char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];

        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) {
                answer[i] = 'D';
                continue;
            }
            if(a[i] == 1 && b[i] == 2) {
                answer[i] = 'B';
            } else if(a[i] == 2 && b[i] == 3) {
                answer[i] = 'B';
            } else if(a[i] == 3 && b[i] == 1) {
                answer[i] = 'B';
            } else {
                answer[i] = 'A';
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 가위바위보에서 이긴 사람 한줄씩 출력(A,B)
        // n번 게임, 1: 가위 2: 바위 3: 보
        RockPaperScissors main = new RockPaperScissors();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(sc.next());
        }

        int[] b = new int[n];
        for(int i=0; i<n; i++) {
            b[i] = Integer.parseInt(sc.next());
        }

        char[] result = main.solution(n, a, b);

        for (char c : result) {
            System.out.println(c);
        }
    }
}
