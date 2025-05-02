package solution;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // a^n * a^n = a^2n
        // 12^58 mod 67 == 4 -> 12^116 mod 67 == 16
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        System.out.println(func(A,B,C));
    }

    private static int func(int a, int b, int c) {
        if(b == 1) return a%c;
        return 0;
    }
}
