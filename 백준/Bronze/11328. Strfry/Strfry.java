import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 개수 0<n<1001
        // 1번 문자열을 무작위로 재배열했을 때 2번 문자열이 될 수 있는지
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            if(s1.length() != s2.length()) {
                System.out.println("Impossible");
                continue;
            }
            int[] sArr = new int[26];
            for(char c : s1.toCharArray()) {
                sArr[c - 'a']++;
            }
            for(char c : s2.toCharArray()) {
                sArr[c - 'a']--;
            }
            boolean flag = true;
            for(int num : sArr) {
                if(num != 0) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "Possible" : "Impossible");
        }

    }

}
