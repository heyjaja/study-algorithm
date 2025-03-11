import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for(char c : s2.toCharArray()) {
            arr2[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                int answer = arr1[i] - arr2[i];
                count += answer < 0 ? -answer : answer;
            }
        }
        System.out.println(count);
    }
}