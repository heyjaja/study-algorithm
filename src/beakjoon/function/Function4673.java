package beakjoon.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Function4673 {
  // 셀프 넘버
  // 양의 정수 n, d(n)은 n과 n의 각 자리수를 더하는 함수
  // n, d(n), d(d(n)), d(d(d(n))), ...
  // 33, 33+3+3=39, 39+3+9=51,... 39의 생성자 33
  // 생성자가 없는 숫자: 셀프 넘버
  // 10000보다 작거나 같은 셀프넘버 출력
  static void selfNum() {
    List<Integer> list = new ArrayList<Integer>();
    
    for(int i=1; i<=10000; i++) { // 10000보다 작거나 같은 수 중 생성자를 가진 수 구하기
      int a=getNum(i);
      list.add(a); // 생성자를 가진 수를 list에 저장
    }
    
    Collections.sort(list); // 검색할 때 편하도록 정렬
    
    for(int i=1; i<=10000; i++) {
      boolean s=true; // 존재여부를 확인하기 위한 변수
      for(int j : list) {
        if(i==j) {
          s=false;
          break;
        }
      }
      if(s) // list에서 찾을 수 없으면 출력
        System.out.println(i);
    }
  }
  
  static int getNum(int i) { //d(i)값을 구하는 메서드
    int ans = i;
    while(i>0) { // 각 자리수를 더한다
      ans += i%10;
      i /= 10;
    }
    return ans;
  }
  
  public static void main(String[] args) {
    selfNum();
  }
}
