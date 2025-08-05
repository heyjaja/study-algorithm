
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        func(0);
    }

    private static void func(int a) { // 현재 a개까지 수를 택함
        if(a == m) { // m개를 모두 택하면
            for (int i = 0; i < m; i++) { // 출력
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int start = a == 0 ? 1 : arr[a-1] + 1; // 시작지점
        for (int i = start; i <= n; i++) { // 1부터 n까지 수에 대해
            arr[a] = i; // a번째 수를 i로 채움
            func(a+1); // 다음칸 채우기
        }
    }
}