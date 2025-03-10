import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        int a = 0, b = 0;
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    a = arr[i];
                    b = arr[j];
                    break;
                }
            }
        }

        for(int i : arr) {
            if(i != a && i != b) {
                System.out.println(i);
            }
        }


    }
}