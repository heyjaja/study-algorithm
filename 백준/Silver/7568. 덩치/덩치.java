import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] rank = new int[n];

        for(int i = 0; i < n; i++) {
            rank[i] = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank[i]++;
                }

            }
            System.out.print(rank[i] + " ");
        }

    }
}
