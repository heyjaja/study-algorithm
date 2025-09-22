import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int[] operator = new int[4]; // + - * /
        for(int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1, operator[0], operator[1], operator[2], operator[3]);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int a, int count, int plus, int minus, int multi, int divide) {
        if(count == n) {
            max = Math.max(max, a);
            min = Math.min(min, a);
            return;
        }

        if(plus > 0) dfs(a + arr[count], count+1, plus - 1, minus, multi, divide);
        if(minus > 0) dfs(a - arr[count], count+1, plus, minus - 1, multi, divide);
        if(multi > 0) dfs(a * arr[count], count+1, plus, minus, multi - 1, divide);
        if(divide > 0) dfs(a / arr[count], count+1, plus, minus, multi, divide - 1);
    }
}