import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ap = "abcdefghijklmnopqrstuvwxyz";
        String s = sc.nextLine();

        int[] arr = new int[ap.length()];
        for (char c : s.toCharArray()) {
            arr[ap.indexOf(c)]++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}