import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double k = sc.nextDouble();

        int[][] arr = new int[2][7];
        for (int i = 0; i < n; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();
            arr[sex][grade]++;
        }

        int count = 0;
        for(int i=1; i<7; i++) {
            if(arr[0][i] != 0) {
                count += Math.ceil((arr[0][i])/k);
            }
            if(arr[1][i] != 0) {
                count += Math.ceil((arr[1][i])/k);
            }
        }

        System.out.println(count);

    }

}