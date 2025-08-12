import java.util.*;
import java.io.*;

public class Main {
    static int n, s;
    static int count;
    static int[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        inputs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if(s == 0) count--; // 크기가 양수인 부분수열만 체크해야하기 때문에 0인 경우 공집합 제외
        System.out.println(count);
    }

    public static void func(int sum, int idx) {

        if(idx == n) { // 백트래킹에서는 모든 원소를 탐색한 후에 종료해야함
            if(sum == s) {
                count++;
            }
            return;
        }

        func(sum + inputs[idx], idx + 1); // 현재 값을 포함
        func(sum, idx + 1); // 현재 값을 미포함

    }
}