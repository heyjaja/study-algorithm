import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 배 0, 등 1
        // 3줄 ABCDE(도개걸윷모)
        Scanner sc = new Scanner(System.in);
        String s = "EABCD";
        char[] charArr = new char[3];
        for(int i=0; i<3; i++) {
            String a = sc.nextLine();
            int count = 0;
            for(String c : a.split(" ")) {
                if("0".equals(c)) count++;
            }
            charArr[i] = s.charAt(count);
        }

        for (char c : charArr) {
            System.out.println(c + " ");
        }

    }
}