
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        isUsed = new boolean[n+1];

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

        for (int i = 1; i <= n; i++) { // 1부터 n까지 수에 대해
            if(!isUsed[i]) { // 아직 i를 사용하지 않았으면
                arr[a] = i; // a번째 수를 i로 채움
                isUsed[i] = true; // i 사용 표시
                func(a+1); // 다음칸 채우기
                isUsed[i] = false; // a번째 수를 i로 사용한 모든 경우의 수 확인 완료
            }

        }
    }
}
