import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            int cursor = 0;
            for (char c : s.toCharArray()) {
                switch (c){
                    case '<':
                        cursor = cursor > 0 ? cursor - 1 : cursor;
                        break;
                    case '>':
                        cursor = cursor < sb.length() ? cursor + 1 : cursor;
                        break;
                    case '-':
                        if(cursor > 0) sb.deleteCharAt(--cursor);
                        break;
                    default:
                        sb.insert(cursor++, c);
                        break;
                }
            }

            System.out.println(sb);
        }
    }

}