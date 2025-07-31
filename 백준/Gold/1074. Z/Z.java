import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    private static int func(int n, int r, int c) {
        // 2^n x 2^n 배열에서 (r, c) 위치의 순서를 구하는 함수
        if (n == 0) {
            return 0; // 기저 사례: 1x1 배열의 경우
        }
        // (r, c)가 1, 2, 3, 4번 사각형일 때
        int half = 1 << (n - 1); // 2^(n-1)
        if (r < half && c < half) {
            // 1번 사각형
            return func(n - 1, r, c);
        } else if (r < half && c >= half) {
            // 2번 사각형
            return half * half + func(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            // 3번 사각형
            return 2 * half * half + func(n - 1, r - half, c);
        } else {
            // 4번 사각형
            return 3 * half * half + func(n - 1, r - half, c - half);
        }
    }
}
