package doit.basic.array;

import java.util.Scanner;

public class CardConvRev {

    static int cardConvR(int x, int r, char[] d) {
        // x = 변환하는 정수, r = 기수, d = 결과 배열
        int digits = 0; // 결과 자리수
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while(x != 0) {
            // 기수로 나눈 나머지 값을 역순으로 저장
            d[digits++] = dchar.charAt(x % r);
            // 59 / 2 ... 1, 29 / 2 ... 1, ...
            x /= r;
        }

        for(int i=0; i<digits/2; i++) {
            // 역순인 배열을 순서대로 정렬
            char temp = d[i];
            d[i] = d[digits-i-1];
            d[digits-i-1] = temp;
        }

        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int r = sc.nextInt();
        char[] cno = new char[32];

        int digits = cardConvR(x, r, cno);
        for(int i = 0; i<digits; i++) {
            System.out.print(cno[i]);
        }
    }
}
