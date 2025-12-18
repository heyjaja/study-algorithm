
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] route = new int[n+1];
        dp[1] = 0;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            route[i] = i-1;
            if(i % 2 == 0 && dp[i/2] < dp[i]) {
                dp[i] = dp[i/2] + 1;
                route[i] = i/2;
            }
            if(i % 3 == 0 && dp[i/3] < dp[i]) {
                dp[i] = dp[i/3] + 1;
                route[i] = i/3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append('\n');
        sb.append(n).append(' ');


        while(n > 1) {
            n = route[n];
            sb.append(n).append(' ');
        }

        System.out.println(sb);
    }
}
