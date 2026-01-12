
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Meeting[] arr = new Meeting[n];

        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 끝나는 시간 - 시작 시간 순으로 정렬(시작하자마자 끝나는 회의 대응)
        Arrays.sort(arr);

        int answer = 0;
        int t = 0;

        for(int i=0; i<n; i++) {
            if(t > arr[i].start) continue;
            answer++;
            t = arr[i].end;
        }

        System.out.println(answer);


    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(end > o.end) {
                return 1;
            } else if(end < o.end) {
                return -1;
            } else {
                if(start > o.start) {
                    return 1;
                } else if(start < o.start) {
                    return -1;
                }
                return 0;
            }
        }
    }
}
