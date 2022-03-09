import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack5_3 {
  public static void solution(int board[][], int moves[]) {
    Stack<Integer> stack = new Stack<Integer>();
    int count=0;
    for(int move : moves) {
      for(int j=0; j<board.length; j++) {
        if(board[j][move-1]==0) {
          continue;
        } 
        if(!(stack.isEmpty()) && stack.peek()==board[j][move-1]) {
          stack.pop();
          count+=2;
          break;
        } else {
           stack.push(board[j][move-1]);
           board[j][move-1]=0;
           break;
        } 
      }
    }
    System.out.println(count);
  }
  public static void main(String[] args) throws IOException {
    // 크레인 인형뽑기
    // 인형뽑기 화면 board, 뽑은 인형바구니 moves
    // 같은 인형이 뽑히면 moves에서 인형이 터짐
    // 입력1> 인형이 담기는 2차원 배열 board n*n (5<=n<=30)
    // 입력2> 인형을 나타내는 숫자 100 이하의 정수 0은 빈칸
    // 입력3> 뽑은 인형이 담기는 배열 moves의 길이 m (1<=m<=100)
    // 입력4> moves의 원소들의 값은 1 이상 board 배열의 가로 크기 이하 지연수
    // 출력> 터진 인형의 개수
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());
    int board[][] = new int[n][n];
    
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<n;j++) {
        board[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int m = Integer.parseInt(br.readLine());
    int moves[] = new int[m];
    
    st = new StringTokenizer(br.readLine(), " ");
    
    for(int i=0; i<m; i++) {
      moves[i] = Integer.parseInt(st.nextToken());
    }
    
    solution(board, moves);
    
  }

}
