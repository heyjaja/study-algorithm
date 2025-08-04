import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void func(int row, int col, int n) {
        if(checkColor(row, col, n)) {
            if(arr[row][col] == 0) white++;
            else blue++;
            return;
        }

        int size = n/2;
        func(row, col, size); // 1
        func(row, col + size, size); // 2
        func(row + size, col, size); // 3
        func(row + size, col + size, size); // 4
    }

    private static boolean checkColor(int row, int col, int n) {
        int color = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if(color != arr[i][j]) return false;
            }
        }
        return true;
    }
}