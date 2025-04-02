import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] prev = new int[100001];
        Arrays.fill(prev, -1); // 0부터 시작할 수 있으니 -1로 초기화
        Queue<Integer> q = new LinkedList<>();
        prev[N] = 1; // 이전 경로를 저장
        q.offer(N);

        while(prev[K] == -1 && !q.isEmpty()) {
            Integer cur = q.poll();
            check(prev, q, cur, cur-1);
            check(prev, q, cur, cur+1);
            check(prev, q, cur, cur*2);
        }

        Stack<Integer> s = new Stack<>();

        s.push(K);

        int index = K;
        while(index != N) { // 목표 위치부터 처음 위치가 나올 때까지 반복하여 stack에 push -> 역추적
            s.push(prev[index]);
            index = prev[index];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.size() - 1).append('\n'); // 스택의 크기가 경로의 길이
        while(!s.isEmpty()) {
            sb.append(s.pop()).append(' ');
        }
        System.out.println(sb);
    }

    private static void check(int[] prev, Queue<Integer> q, Integer cur, int nx) {
        if(nx < 0 || nx >= prev.length) return;
        if(prev[nx] > -1) return; // prev[nx]가 -1 이상이면 이미 방문한 위치
        prev[nx] = cur; // 다음 위치 index에 현재 위치 저장, 다음 위치 전 방문한 위치가 현재 위치가 됨
        q.offer(nx);
    }
}
