package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Ssileumer {

    static class Applicant implements Comparable<Applicant> {
        int height;
        int weight;

        public Applicant(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "A[h=" + height + ", w=" + weight + "]";
        }

        @Override
        public int compareTo(Applicant o) {
            if(height > o.height) {
                return -1;
            }

            if(height < o.height) {
                return 1;
            }
            return 0;
        }
    }

    private int solution(Applicant[] applicants) {
        // 이중 포문은 시간 초과 O(n2)
        // 키 내림차순으로 정렬하여 몸무게만 비교
        int answer = 0;

        Arrays.sort(applicants);

        int max = 0;

        for(Applicant a : applicants) {
            if(a.weight > max) {
                answer++;
                max = a.weight;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 씨름선수
        // N명의 지원자
        // 지원자의 키, 몸무게
        // A라는 지원자를 다른 모든 지원자와 비교하여 키와 몸무게 모두
        // A 지원자보다 크고 무거운 지원자가 존재하면 탈락 그렇지 않으면 선발
        // 선발할 수 있는 최대 선수의 수
        Ssileumer main = new Ssileumer();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Applicant[] applicants = new Applicant[n];

        for(int i=0; i<n; i++) {
            applicants[i] = new Applicant(sc.nextInt(), sc.nextInt());
        }

        System.out.println(main.solution(applicants));
    }
}
