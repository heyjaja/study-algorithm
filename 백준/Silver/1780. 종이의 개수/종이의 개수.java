import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

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

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void func(int row, int col, int n) {
        if(checkNumber(row, col, n)) {
            if(arr[row][col] == -1) minus++;
            else if(arr[row][col] == 0) zero++;
            else plus++;
            return;
        }

        int size = n/3;
        int row2 = row + size;
        int row3 = row + size * 2;
        int col2 = col + size;
        int col3 = col + size * 2;
        func(row, col, size); // 1
        func(row, col2, size); // 2
        func(row, col + size * 2, size); // 3
        func(row2, col, size); // 4
        func(row2, col2, size); // 5
        func(row2, col3, size); // 6
        func(row3, col, size); // 7
        func(row3, col2, size); // 8
        func(row3, col3, size); // 9
    }

    private static boolean checkNumber(int row, int col, int n) {
        int num = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if(num != arr[i][j]) return false;
            }
        }
        return true;
    }
}