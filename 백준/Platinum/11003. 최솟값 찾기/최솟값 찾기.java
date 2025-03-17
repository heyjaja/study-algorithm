import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Number> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            Number num = new Number(i+1, Integer.parseInt(st.nextToken()));
            if(!dq.isEmpty() && dq.peekFirst().index < num.index - l + 1) { // 범위를 벗어나는 요소 삭제
                dq.pollFirst();
            }

            // 현재 값이 더 작다면 덱에 있는 현재 값 보다 큰 값은 미래에 최솟값(과거는 이미 처리됨)이 될 수 없음
            while(!dq.isEmpty() && dq.peekLast().value > num.value) dq.pollLast(); // 오름차순을 유지하기 위해 제거
            dq.addLast(num); // 새로운 값을 덱의 마지막에 추가하여 최솟값/오래된 값을 맨 앞으로 유지
            sb.append(dq.peekFirst().value).append(' ');
        }
        System.out.println(sb);

    }

}

class Number {
    int index;
    int value;

    public Number(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
