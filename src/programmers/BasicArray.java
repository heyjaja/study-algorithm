package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicArray {
    public int[] multipleOfN (int n, int[] numlist) {
        int[] answer = {};
        answer = Arrays.stream(numlist).filter(a -> a%n == 0).toArray();
        return answer;
    }

    public int findNumber(int num, int k) {
        int answer = 0;
        String strNum = num + "";
        answer = strNum.indexOf(k+"");
        return answer > 0 ? answer + 1 : answer;
    }

    public int similarArray(String[] s1, String[] s2) {
        int answer = 0;
        for (String s : s1) {
            for (String ss : s2) {
                if(s.equals(ss)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public int calString(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        answer = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].equals("+")) {
                answer = answer + Integer.parseInt(arr[i+1]);
            }

            if(arr[i].equals("-")) {
                answer = answer - Integer.parseInt(arr[i+1]);
            }
        }

        return answer;
    }

    public int[] maxNumber(int[] array) {
        int[] answer = new int[2];

        for (int i = 1; i < array.length; i++) {
            if(answer[0] < array[i]) {
                answer[0] = array[i];
                answer[1] = i;
                break;
            }
        }

        return answer;
    }

    public int[] divisor(int n) {
        int[] answer = {};
        answer = IntStream.rangeClosed(1, n).filter(v -> 24%v == 0).toArray();
        return answer;
    }

    public int[] solution(String my_string) {
        int[] answer = {};

        my_string = my_string.replaceAll("[a-z]", "");
        answer = my_string.chars().map(c -> c - 48).sorted().toArray();
        return answer;
    }

    public static void main(String[] args) {
        BasicArray ba = new BasicArray();
        System.out.println(ba.calString("3 + 4 + 11"));
        System.out.println(ba.maxNumber(new int[]{1, 8, 3})[0]);
        for(int i: ba.divisor(24)) {
            System.out.println(i);
        }
    }

}
