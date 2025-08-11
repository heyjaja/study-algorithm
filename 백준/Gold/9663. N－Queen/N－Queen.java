import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int count;
    static boolean[] xy;
    static boolean[] xPlusY;
    static boolean[] xMinusY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        xy = new boolean[n*2];
        xPlusY = new boolean[n*2];
        xMinusY = new boolean[n*2];

        func(0);
        System.out.println(count);
    }

    public static void func(int cur) { // cur: 줄(x)
        if(cur == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) { // i: 열(y)
            if(xy[i] || xPlusY[cur + i] || xMinusY[cur - i + n - 1]) continue;
            xy[i] = true;
            xPlusY[cur+i] = true;
            xMinusY[cur-i+n-1] = true;

            func(cur + 1);

            xy[i] = false;
            xPlusY[cur+i] = false;
            xMinusY[cur-i+n-1] = false;
        }
    }
}