import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int y = 0;
        int m = 0;
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            y += (a/30 + 1) * 10;
            m += (a/60 + 1) * 15;
        }

        StringBuilder sb = new StringBuilder();
        if(y < m) {
            sb.append("Y ").append(y);
        } else if(m < y) {
            sb.append("M ").append(m);
        } else {
            sb.append("Y M ").append(y);
        }

        System.out.println(sb);
    }
}