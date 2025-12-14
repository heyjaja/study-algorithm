import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new long[n];

        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(function());
    }

    private static long function() {
        int count = 1; // 현재 값이 등장한 횟수(arr[0] value count)
        long maxValue = Long.MIN_VALUE; // 가장 많이 등장한 값
        int maxCount = 0; // 가장 많이 등장한 값의 등장 횟수

        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                if(maxCount < count) {
                    maxCount = count;
                    maxValue = arr[i-1];
                }
                count = 1;
            }
        }

        if(maxCount < count) maxValue = arr[n-1];

        return maxValue;

    }
}
