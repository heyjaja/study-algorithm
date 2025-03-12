
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split("");
        int n = Integer.parseInt(br.readLine());
        StringList list = new StringList();
        int cursor = 0;
        for (; cursor < init.length; cursor++) {
            list.insert(cursor, init[cursor]);
        }

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            switch(command) {
                case "L":
                    cursor = list.getPrev(cursor);
                    break;
                case "D":
                    cursor = list.getNext(cursor);
                    break;
                case "B":
                    cursor = list.erase(cursor);
                    break;
                case "P":
                    cursor = list.insert(cursor, st.nextToken());
                    break;
            }
        }

        list.print();
    }

}

class StringList {
    int max = 600001;
    String[] data = new String[max];
    int[] prev = new int[max];
    int[] next = new int[max];
    int unused = 1;
    int size = 0;

    public StringList() {
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
    }

    public int insert(int addr, String value) {
        data[unused] = value;
        prev[unused] = addr;
        next[unused] = next[addr];
        if(next[addr] > -1) prev[next[addr]] = unused;
        next[addr] = unused;
        size++;
        return unused++;
    }

    public int erase(int addr) {
        if(addr == 0) return addr;
        next[prev[addr]] = next[addr];
        if(next[addr] > -1) prev[next[addr]] = prev[addr];
        size--;
        return getPrev(addr);
    }

    public int size() {
        return this.size;
    }

    public void print() {
        int addr = next[0];
        StringBuilder sb = new StringBuilder();
        while(addr != -1) {
            sb.append(data[addr]);
            addr = next[addr];
        }
        System.out.print(sb);
    }

    public int getNext(int cursor) {
        return next[cursor] != -1 ? next[cursor] : cursor;
    }

    public int getPrev(int cursor) {
        return prev[cursor] != -1 ? prev[cursor] : cursor;
    }
}