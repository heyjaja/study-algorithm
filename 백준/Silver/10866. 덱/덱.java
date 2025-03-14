import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}