package array;

import java.util.Scanner;

public class Mentoring {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int a=0, b=0, count;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                count = 0;
                for(int k=0; k<m; k++) {
                    for(int l=0; l<n; l++) {
                        if(i == arr[k][l]) {
                            a = l;
                        }
                        if(j == arr[k][l]) {
                            b = l;
                        }
                    }
                    if(a < b) {
                        count++;
                    } else {
                        break;
                    }
                }
                if(count == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 멘토링
        // M번의 수학테스트 등수로 멘토-멘티
        // A-B A는 모든 수학테스트에서 B보다 등수가 높아야 한다.
        // 짝을 만들 수 있는 경우의 수 출력
        // 학생 수 N, 테스트 M번
        // 1등부터 학생 번호 순서
        Mentoring main = new Mentoring();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j=0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(main.solution(n, m, arr));
    }

}
