import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int pl = a - 1;
            int pr = b - 1;
            while(pl < pr) {
                int temp = arr[pl];
                arr[pl++] = arr[pr];
                arr[pr--] = temp;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
