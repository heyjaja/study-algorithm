import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String command = br.readLine();
            int m = Integer.parseInt(br.readLine());
            Deque<Integer> dq = getDeque(br.readLine(), m);

            boolean reverse = false;
            boolean error = false;
            for(char c : command.toCharArray()) {
                if(c=='R') {
                    reverse = !reverse;
                } else if(c == 'D') {
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if(reverse) dq.pollLast();
                    else dq.pollFirst();
                }
            }

            if(error) {
                sb.append("error").append('\n');
            } else {
                sb.append('[');
                while (!dq.isEmpty()) {
                    sb.append(reverse ? dq.pollLast() : dq.pollFirst()).append(dq.isEmpty() ? "" : ',');
                }
                sb.append(']').append('\n');
            }

        }

        System.out.println(sb);

    }

    private static Deque<Integer> getDeque(String arr, int m)  {
        Deque<Integer> dq = new ArrayDeque<>();

        if(m==0) return dq;

        for (String s : arr.substring(1, arr.length()-1).split(",")) {
            dq.offer(Integer.parseInt(s));
        }

        return dq;
    }

}
