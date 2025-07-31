package solution;

import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        func(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void func(int x, int y, int n, boolean isBlank) {
        if(isBlank) {
            for(int i = x; i < x + n; i++) {
                for(int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0;

        for (int i = x; i < x + n; i += size) {
            for(int j = y; j < y+n; j += size) {
                count++;
                func(i, j, size, count == 5); // count == 5는 3x3의 가운데 칸 공백 여부
            }

        }
    }
}
