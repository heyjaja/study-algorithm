import java.util.*;
import java.io.*;

public class Main {

    static int[] arr = new int[6];
    static int[] inputs;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            inputs = new int[n];
            for(int i=0; i<n; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }
            sb = new StringBuilder();
            func(0, 0);
            System.out.println(sb);
        }
    }

    private static void func(int a, int idx) {
        if(a == 6) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=idx; i<n; i++) {
            arr[a] = inputs[i];
            func(a+1, i + 1);
        }
    }
}