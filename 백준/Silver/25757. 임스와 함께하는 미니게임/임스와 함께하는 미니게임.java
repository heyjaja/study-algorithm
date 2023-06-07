import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int count = 0;
        switch (game) {
            case "Y": count = 2;
            break;
            case "F": count = 3;
            break;
            case "O": count = 4;
        }

        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        int result = (int)Math.ceil(set.size()/(count-1));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    }
}
