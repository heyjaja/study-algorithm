package basic.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    int money;
    int days;

    public Lecture(int money, int days) {
        this.money = money;
        this.days = days;
    }

    @Override
    public int compareTo(Lecture o) {
        if(days > o.days) {
            return -1;
        }

        if(days < o.days) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return money + " " + days;
    }
}
public class MaximumIncome {

    private int solution(Lecture[] lectures) {
        int answer = 0;

        // 날짜순으로 내림차순
        Arrays.sort(lectures);

        // 가장 먼 날짜 구하기
        int day = Arrays.stream(lectures)
                .max((o1, o2) -> o1.days > o2.days ? 1 : -1)
                .get().days;

        // 기본: 작은 값부터 poll
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

        int j = 0;
        // 가장 먼 날짜부터 큐에 수입을 넣고 날짜가 바뀌면 최고값 +
        for(int i=day; i>=1; i--) {
            for(; j < lectures.length; j++) {
                if(i > lectures[j].days) {
                    break;
                }
                pQ.offer(lectures[j].money);
            }
            if(!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 최대 수입 스케줄(우선순위큐 PriorityQueue 응용)
        // N개의 기업에서 D일 안에 강연을 하면 강연료 M 지급
        // D와 M을 바탕으로 가장 많은 수입 스케줄
        // 하루에 하나의 기업에서 강연
        MaximumIncome main = new MaximumIncome();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Lecture[] lectures = new Lecture[n];

        for(int i=0; i<n; i++) {
            lectures[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }

        System.out.println(main.solution(lectures));
    }

}
