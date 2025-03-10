package barkingdog.array;

import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[(c - 'a')]++; // 아스키코드를 활용
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
