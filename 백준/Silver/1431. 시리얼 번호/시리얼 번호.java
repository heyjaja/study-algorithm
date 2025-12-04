import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] guitars = new String[n];

        for(int i=0; i<n; i++) {
            guitars[i] = br.readLine();
        }

        Arrays.sort(guitars, (s1, s2) -> {
            if(s1.length() != s2.length()) {
                if(s1.length() < s2.length()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                if(sum(s1) < sum(s2)) {
                    return -1;
                } else if(sum(s1) > sum(s2)) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for(String guitar : guitars) {
            System.out.println(guitar);
        }
    }

    private static int sum(String s) {
        int sum = 0;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    }
}