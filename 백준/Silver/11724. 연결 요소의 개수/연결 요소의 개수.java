import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1; i<=n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
            count++;
        }

        System.out.println(count);
    }

    private static void dfs(int a) {
        for(Integer b : list.get(a)) {
            if(visited[b]) continue;
            visited[b] = true;
            dfs(b);
        }
    }
}