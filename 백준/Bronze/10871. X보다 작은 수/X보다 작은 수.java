import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 10 5
        // 1 10 4 9 2 3 8 5 7 6
        // 1 4 2 3
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[a];
        for(int i=0; i<a; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i=0; i<a; i++) {
            if(arr[i] < n) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}