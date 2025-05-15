import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append((1<<n) -1).append('\n');
        func(1, 3, n, sb);
        System.out.println(sb);
    }

    private static void func(int a, int b, int n, StringBuilder sb) {
        if(n==1){
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        func(a, 6-a-b, n-1, sb);
        sb.append(a).append(" ").append(b).append('\n');
        func(6-a-b, b, n-1, sb);
    }
}