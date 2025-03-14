import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            dq.offer(i+1);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());

            while(a != dq.peekFirst()) {
                Iterator<Integer> asc = dq.iterator();
                Iterator<Integer> desc = dq.descendingIterator();
                boolean front = true;
                while(asc.hasNext() && desc.hasNext()) {
                    if(asc.next() == a) {
                        front = true;
                        break;
                    }
                    if(desc.next() == a) {
                        front = false;
                        break;
                    }
                }

                if(front) {
                    dq.offerLast(dq.pollFirst());
                    count++;
                } else {
                    dq.offerFirst(dq.pollLast());
                    count++;
                }

            }

            if(a == dq.peekFirst()) {
                dq.pollFirst();
            }
        }

        System.out.println(count);
    }
}