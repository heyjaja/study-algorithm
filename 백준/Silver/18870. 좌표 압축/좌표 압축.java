import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<sorted.length; i++) {
            map.put(sorted[i], i);
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int num = map.getOrDefault(arr[i], 0);
            sb.append(num).append(' ');
        }

        System.out.println(sb);
    }
}