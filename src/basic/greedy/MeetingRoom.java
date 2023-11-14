package greedy;

import java.util.Arrays;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(end < o.end) {
            return -1;
        }

        if(end > o.end) {
            return 1;
        }

        if(start < o.start) {
            return -1;
        }
        if(start > o.start) {
            return 1;
        }

        return 0;
    }
}

public class MeetingRoom {


    public static void main(String[] args) {
        // 회의실 배정
        // 1개의 회의실에 n개의 회의 배정
        // 시작시간, 끝나는 시간 겹치지 않게 최대한 많이
        // 끝나는 것과 동시에 회의 시작 가능
        // n개의 회의, 0시부터 시작, 시작시간 <= 끝나는 시간
        MeetingRoom main = new MeetingRoom();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];

        for(int i=0; i<n; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        System.out.println(main.solution(meetings));

    }

    private int solution(Meeting[] meetings) {
        // 회의가 빨리 끝나는 것을 기준으로 정렬
        // 끝나는 시간이 같으면 시작 시간도 비교하여 오름차순
        int answer = 0;

        Arrays.sort(meetings);
        int nextStart = 0;

        for(Meeting m : meetings) {
            if(m.start >= nextStart) {
                nextStart = m.end;
                answer++;
            }
        }

        return answer;
    }
}
