package basic.array;

import java.util.Scanner;

public class Peak {
    public int solution(int n, int[][] arr) {
        int answer = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {
                boolean flag = true;
                int a = arr[i][j];
                if(i-1 >= 0 && a <= arr[i-1][j]) {
                    flag = false;
                }
                if (i+1 < n && a <= arr[i+1][j]) {
                    flag = false;
                }
                if(j-1 >= 0 && a <= arr[i][j-1]) {
                    flag = false;
                }
                if (j+1 < n && a <= arr[i][j+1]) {
                    flag = false;
                }

                if(flag) answer++;
            }
        }
        return answer;
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution2(int n, int[][] arr) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >=0 && nx < n && ny >=0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 봉우리
        // 자신의 상하좌부 숫자보다 큰 숫자는 봉우리
        // 격자의 가장자리는 0으로 초기화
        Peak main = new Peak();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j=0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(main.solution2(n, arr));
    }
}
