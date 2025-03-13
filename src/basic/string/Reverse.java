package basic.string;

import java.util.Scanner;

public class Reverse {
    public void solution(String[] arr) {
        for(int i = 0; i<arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);

            arr[i] = sb.reverse().toString();
        }
    }

    public void solution2(String[] arr) {
        // index 이용 -> 0++ <-> length--
        for(int i = 0; i < arr.length; i++) {
            char[] c = arr[i].toCharArray();

            int lt = 0;
            int rt = c.length - 1;
            while(lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            arr[i] = String.valueOf(c);
        }
    }
    public static void main(String[] args) {
        // N개의 단어를 거꾸로
        Reverse main = new Reverse();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        main.solution2(arr);

        for(String s : arr) {
            System.out.println(s);
        }
    }

}
