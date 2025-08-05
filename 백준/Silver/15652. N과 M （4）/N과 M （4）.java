
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        sb = new StringBuilder();

        func(0);
        System.out.print(sb);
    }

    private static void func(int a) { // 현재 a개까지 수를 택함
        if(a == m) { // m개를 모두 택하면
            for (int i = 0; i < m; i++) { // 출력
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int start = a == 0 ? 1 : arr[a - 1];

        for (int i = start; i <= n; i++) { // 1부터 n까지 수에 대해
            arr[a] = i; // a번째 수를 i로 채움
            func(a+1);// 다음칸 채우기
        }
    }
}
