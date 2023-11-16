package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TimeTwo implements Comparable<TimeTwo> {
    int time;
    String status;

    public TimeTwo(int time, String status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(TimeTwo o) {
        if(time < o.time) {
            return -1;
        }

        if(time > o.time) {
            return 1;
        }

        if(status.equals("leave")) {
            return -1;
        }

        if(o.status.equals("leave")) {
            return 1;
        }

        return 0;
    }
}
public class WeddingTwo {
    private int solution(ArrayList<TimeTwo> times) {
        int answer = 0;

        Collections.sort(times);
        int guest = 0;

        // 시간 순서대로 돌면서 도착하면 +, 떠나면 -
        for(TimeTwo t : times) {
            if(t.status.equals("arrive")) {
                guest++;
                continue;
            }
            answer = Math.max(answer, guest);
            guest--;
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
        WeddingTwo main = new WeddingTwo();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<TimeTwo> times = new ArrayList<>();
        for(int i=0; i<n; i++) {
            times.add(new TimeTwo(sc.nextInt(), "arrive"));
            times.add(new TimeTwo(sc.nextInt(), "leave"));
        }

        System.out.println(main.solution(times));
    }

}
