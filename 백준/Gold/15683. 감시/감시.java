import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m; // 사무실 NxM
    static int[][] office1;
    static int[][] office2;
    static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office1 = new int[n][m];
        office2 = new int[n][m];

        int min = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                office1[i][j] = Integer.parseInt(st.nextToken());
                if(office1[i][j] != 0 && office1[i][j] != 6) cctv.add(new int[]{i, j});
                if(office1[i][j] == 0) min++;
            }
        }
        int number = pow(cctv.size());
        for(int tmp=0; tmp < number; tmp++) { // 모든 경우의 수 4^k-1
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    office2[i][j] = office1[i][j];
                }
            }
            int brute = tmp;
            for(int[] item : cctv) {
                int dir = brute%4;
                brute /= 4;
                int x = item[0];
                int y = item[1];

                if(office2[x][y] == 1) {
                    udp(x,y,dir);
                } else if(office2[x][y] == 2) {
                    udp(x, y, dir);
                    udp(x, y, dir +2);
                } else if(office2[x][y] == 3) {
                    udp(x, y, dir);
                    udp(x, y, dir+1);
                } else if(office2[x][y] == 4) {
                    udp(x, y, dir);
                    udp(x,y,dir+1);
                    udp(x, y, dir+2);
                } else if(office2[x][y] == 5) {
                    udp(x, y, dir);
                    udp(x,y,dir+1);
                    udp(x, y, dir+2);
                    udp(x, y, dir+3);
                }

            }

            int val = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(office2[i][j] == 0) {
                        val++;
                    }
                }
            }
            min = Math.min(min, val);
        }


        System.out.println(min);



    }

    private static void udp(int x, int y, int dir) {
        dir %= 4;
        while(true) {
            x += dx[dir];
            y += dy[dir];
            if(x < 0 || x >= n || y < 0 || y >= m || office2[x][y] == 6) return;
            if(office2[x][y] != 0 ) continue;
            office2[x][y] = 7;
        }
    }

    private static int pow(int size) {
        int number = 1;
        for(int i=0; i<size; i++) {
            number*=4;
        }
        return number;
    }
}