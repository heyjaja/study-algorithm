import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 7개 자연수
        // 홀수의 합 \n 최솟값
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean flag = false;
        for(int i=0; i<7; i++) {
            int n = sc.nextInt();
            if(n % 2 != 0) {
                flag = true;
                sum += n;
                if(min > n) {
                    min = n;
                }
            }
        }
        
        if(flag) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
        

    }
}