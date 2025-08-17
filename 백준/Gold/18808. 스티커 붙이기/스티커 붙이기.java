import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] notebook;
    static int r, c;
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        notebook = new int[n][m];
        sticker = new int[10][10];

        while(k > 0){
            k--;
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for(int i=0; i<r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++) { // 0, 90, 180, 270 회전하는 경우
                boolean isStuck = false; // 스티커를 붙인 경우
                for(int x=0; x<=n-r; x++) { // 스티커는 좌상단부터 붙임
                    if(isStuck) break;
                    for(int y=0; y<=m-c; y++) {
                        if(canStuck(x, y)) { // 부착 가능 여부 및 부착 한번에
                            isStuck = true;
                            break;
                        }
                    }
                }
                if(isStuck) break; // 붙이면 종료
                rotate(); // 회전
            }

        }

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(notebook[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    private static void rotate() { // 90도 회전
        int[][] temp = new int[10][10];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                temp[i][j] = sticker[i][j];
            }
        }

        for(int i=0; i<c; i++) {
            for(int j=0; j<r; j++) {
                sticker[i][j] = temp[r-1-j][i]; // b[x][y] = a[n-1-y][x]
            }
        }

        int t = r;
        r = c;
        c = t;
    }

    private static boolean canStuck(int x, int y) {
        for(int i=0; i<r; i++) { // 붙일 수 있는지 확인
            for(int j=0; j<c; j++) {
                if(notebook[x+i][y+j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }
        for(int i=0; i<r; i++) { // 스티커 붙이기
            for(int j=0; j<c; j++) {
                if(sticker[i][j] == 1) {
                    notebook[x+i][y+j] = 1;
                }
            }
        }
        return true;
    }
}