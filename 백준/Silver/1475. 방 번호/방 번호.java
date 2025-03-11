import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 다솜이의 방 번호 N <= 1000000
        // 0~9 숫자 세트(6, 9는 서로 대체 가능) 몇 개 필요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10];

        while(n > 0) {
            int x = n%10;
            if(x == 6 || x == 9) {
                if(arr[6] < arr[9]) {
                    arr[6]++;
                } else {
                    arr[9]++;
                }
            } else {
                arr[x]++;
            }
            n/=10;
        }

        System.out.println(Arrays.stream(arr).max().getAsInt());
    }

}