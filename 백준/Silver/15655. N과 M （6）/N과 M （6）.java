import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] inputs;
    static int[] arr;
    static boolean[] visits;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputs = new int[n];
        arr = new int[n];
        visits = new boolean[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();

        Arrays.sort(inputs);
        func(0, 0);
        System.out.print(sb);
    }

    public static void func(int a, int idx) {
        if(a == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int b = a == 0 ? 0 : idx;

        for(int i=b; i<n; i++) {
            if(!visits[i]) {
                arr[a] = inputs[i];
                visits[i] = true;
                func(a + 1, i+1);
                visits[i] = false;
            }
        }

    }
}