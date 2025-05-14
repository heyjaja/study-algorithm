import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // a^n * a^n = a^2n
        // 12^58 mod 67 == 4 -> 12^116 mod 67 == (4*4) mod 67 == 16
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(func(A,B,C));
    }

    private static long func(long a, long b, long c) {
        if(b == 1) return a%c; // base condition
        long val = func(a, b/2, c); // a의 b승을 구할 때 a의 b/2승 * a의 b/2 승을 하면 a^b를 구할 수 있음
        val = val * val % c; // 여기서 a의 b/2승 * a의 b/2승
        if(b%2 == 0) return val; // b가 2로 나누어진다면 val이 답이 되고, b%2가 1이면 a를 한번 더 곱해줌
        return val * a % c;
    }
}
