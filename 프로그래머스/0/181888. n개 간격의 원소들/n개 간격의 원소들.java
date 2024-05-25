class Solution {
    public int[] solution(int[] num_list, int n) {
        int length = (num_list.length + n - 1) / n;
        
        int[] answer = new int[length];
        
        for(int i=0; i<num_list.length; i++) {
            if(i % n == 0) {
                answer[i/n] = num_list[i];
            }
        }
        
        return answer;
    }
}