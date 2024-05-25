import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
        
        return String.join("", arr);
    }
}