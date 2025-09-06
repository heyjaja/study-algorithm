import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.stream(arr).sorted(((o1, o2) -> {
            if(o1.length() < o2.length()) return -1;
            else if(o1.length() > o2.length()) return 1;
            else {
                return o1.compareTo(o2);
            }
        })).distinct().forEach(System.out::println);
    }
}