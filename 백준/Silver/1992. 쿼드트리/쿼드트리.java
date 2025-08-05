import java.io.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        func(0, 0, n);
    }

    private static void func(int row, int col, int n) {
        if(checkNumber(row, col, n)) {
            System.out.print(arr[row][col]);
            return;
        }
        System.out.print('(');

        int size = n/2;
        func(row, col, size); // 1
        func(row, col + size, size); // 2
        func(row + size, col, size); // 3
        func(row + size, col + size, size); // 4
        System.out.print(')');
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
