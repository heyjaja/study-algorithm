import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[21];
        
        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            switch(st.nextToken()) {
                case "add":
                    arr[Integer.parseInt(st.nextToken())] = 1;
                    break;
                case "remove":
                    arr[Integer.parseInt(st.nextToken())] = 0;
                    break;
                case "check":
                    sb.append(arr[Integer.parseInt(st.nextToken())]).append("\n");
                    break;
                case "toggle":
                    int x = Integer.parseInt(st.nextToken());
                    arr[x] = arr[x] == 1 ? 0 : 1;
                    break;
                case "all":
                    Arrays.fill(arr, 1);
                    break;
                case "empty":
                    Arrays.fill(arr, 0);
                    break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        
        
    }
}