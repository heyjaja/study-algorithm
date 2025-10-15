import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m  = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st =  new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int a) {
        for (Integer i : graph.get(a)) {
            if(visited[i]) continue;
            visited[i] = true;
            count++;
            dfs(i);
        }
    }
}