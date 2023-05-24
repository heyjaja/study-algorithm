class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int length = board.length;
        
        int[][] safe = new int[length][length];
        for(int i = 0; i<length; i++) {
            for(int j = 0; j<length; j++) {
                if(board[i][j] == 1) {
                    safe[i][j] = 1;
                    if(i > 0) safe[i-1][j] = 1;
                    if(i < length - 1) safe[i+1][j] = 1;
                    if(j > 0) safe[i][j-1] = 1;
                    if(j < length - 1) safe[i][j+1] = 1;
                    if(i > 0 && j > 0) safe[i-1][j-1] = 1;
                    if(i > 0 && j < length-1) safe[i-1][j+1] = 1;
                    if(i < length-1 && j < length - 1) safe[i+1][j+1] = 1;
                    if(i < length - 1 && j > 0) safe[i+1][j-1] = 1;
                    
                }
            }
        }
        for(int i = 0 ; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(safe[i][j]==0) answer++;
            }
        }
        return answer;
    }
}