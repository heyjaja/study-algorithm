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
            if(!dq.isEmpty() && dq.peekFirst().index < num.index - l + 1) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.peekLast().value > num.value) dq.pollLast();
            dq.addLast(num);
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