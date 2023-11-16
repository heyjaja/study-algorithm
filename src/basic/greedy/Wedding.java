package greedy;

import java.util.Arrays;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int time;
    int number; // 도착 1, 떠남 -1

    public Time(int time, int number) {
        this.time = time;
        this.number = number;
    }

    @Override
    public int compareTo(Time o) {
        if(time < o.time) {
            return -1;
        }

        if(time > o.time) {
            return 1;
        }

        return number;
    }
}
public class Wedding {
    private int solution(Time[] times) {
        int answer = 0;

        Arrays.sort(times);
        int guest = 0;

        // 시간 순서대로 돌면서 도착하면 +, 떠나면 -
        for(Time t : times) {
            guest += t.number;
            answer = Math.max(answer, guest);
        }

        return answer;
    }
    public static void main(String[] args) {
        // 결혼식
        // 장소를 빌려 3일간 쉬지 않고 피로연 진행
        // 친구 N명의 참석 시간 정보(도착~떠남)
        // 동시에 존재하는 최대 인원수를 수용할 수 있는 장소
        // 도착시간에 존재, 떠나는 시간에 존재x
        // 피로연 참석 인원 수 N
        // 0~72시까지 시간 정보
        Wedding main = new Wedding();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Time[] times = new Time[n*2];
        for(int i=0; i<n*2; i+=2) {
            times[i] = new Time(sc.nextInt(), 1);
            times[i+1] = new Time(sc.nextInt(), -1);
        }

        System.out.println(main.solution(times));
    }

}
