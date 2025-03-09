import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 배 0, 등 1
        // 3줄 ABCDE(도개걸윷모)
        Scanner sc = new Scanner(System.in);
        String s = "DCBAE";
        for(int i=0; i<3; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count += sc.nextInt();
            }
            System.out.println(s.charAt(count));
        }

    }
}