import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] town;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        town = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                town[i][j] = Integer.parseInt(st.nextToken());
                if(town[i][j] == 1) house.add(new Point(i,j));
                if(town[i][j] == 2) chicken.add(new Point(i,j));
            }
        }

        visited = new boolean[chicken.size()];

        back(0, 0);

        System.out.println(min);
    }

    static void back(int start, int count) {
        if(count == m) {
            int dist = 0;

            for(Point p : house) {
                int temp = Integer.MAX_VALUE;

                for(int i=0; i<chicken.size(); i++) {
                    if(!visited[i]) continue;
                    temp = Math.min(temp, Math.abs(p.x - chicken.get(i).x) + Math.abs(p.y - chicken.get(i).y));
                }
                dist += temp;
            }
            min = Math.min(min, dist);
            return;
        }

        for(int i=start; i<chicken.size(); i++) {
            visited[i] = true;
            back(i + 1, count + 1);
            visited[i] = false;
        }

    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}