import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int m;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m  = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st =  new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int a) {
        for(int i=1; i<=n; i++) {
            if(arr[a][i] == 1) {
                if(visited[i]) continue;
                visited[i] = true;
                count++;
                dfs(i);
            }
        }
    }
}