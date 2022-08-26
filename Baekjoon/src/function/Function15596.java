package function;

public class Function15596 {
// 정수 n개가 주어졌을 때 n개의 합을 구하는 함수
// a:합을 구해야하는 정수 n개가 저장되어 있는 배열
// 리턴값: a에 포함되어 있는 정수 n개의 합
  long sum(int[] a) {
    long ans=0;
    for(int i : a) {
      ans+=i;
    }
    return ans;
  }
}