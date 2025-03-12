import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            LinkedList<Character> words = new LinkedList<>();
            ListIterator<Character> cursor = words.listIterator();

            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                switch (c){
                    case '<':
                        if(cursor.hasPrevious()) cursor.previous();
                        break;
                    case '>':
                        if(cursor.hasNext()) cursor.next();
                        break;
                    case '-':
                        if(cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(c);
                        break;
                }
            }

            for (Character word : words) {
                sb.append(word);
            }

            System.out.println(sb);
        }
    }

}