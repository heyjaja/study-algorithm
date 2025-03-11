import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 다솜이의 방 번호 N <= 1000000
        // 0~9 숫자 세트(6, 9는 서로 대체 가능) 몇 개 필요
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[10];

        for(char c : s.toCharArray()) {
            int index = c - '0';
            if(index == 6 || index == 9) {
                if(arr[6] < arr[9]) {
                    arr[6]++;
                } else {
                    arr[9]++;
                }
            } else {
                arr[index]++;
            }
        }

        int max = 0;
        for (int i : arr) {
            if(i>max) max = i;
        }

        System.out.println(max);
    }

}