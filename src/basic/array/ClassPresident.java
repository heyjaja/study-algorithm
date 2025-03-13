package basic.array;

import java.util.Scanner;

public class ClassPresident {
    public int solution(int n, int[][] arr) {
        int answer = 0;
//        int[] students = new int[n];
        int count = 0;
        int max = 0;

        for(int i=0; i<n; i++) {
            count = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<5; k++) {
                    if(arr[i][k] == arr[j][k]) {
//                        students[i]++;
                        count++;
                        break; // 학생 당 1번만 카운팅
                    }
                }
            }
            if(count > max) {
                max = count;
                answer = i + 1;
            }
        }

//        for(int i=1; i<n; i++) {
//            if(students[answer] < students[i]) {
//                answer = i;
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {
        // 임시반장
        // 같은 반이었던 사람이 가장 많은 학생(여러 명인 경우 가장 작은 번호)
        // 학생 수 n
        // 1학년, 2학년, ... 5학년
        // 1 <= m <= 9 반 5x5
        ClassPresident main = new ClassPresident();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++) {
            for(int j=0; j < 5; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(main.solution(n, arr));
    }
}
