import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();

        if(a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        System.out.println(a == b ? 0 : b - a - 1);
        for (long i = a+1; i < b; i++) {
            System.out.print(i + " ");
        }
    }
}