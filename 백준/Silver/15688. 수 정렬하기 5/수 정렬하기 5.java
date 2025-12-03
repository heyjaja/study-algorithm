import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a =  Integer.parseInt(br.readLine()) + 1000000;
            arr[a]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;
            for(int j=0; j<arr[i]; j++) {
                sb.append(i-1000000).append('\n');
            }
        }

        System.out.println(sb);

    }
}
