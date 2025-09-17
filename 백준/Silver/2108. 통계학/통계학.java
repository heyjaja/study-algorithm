import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(sum/n)).append('\n');
        sb.append(arr[(n-1)/2]).append('\n');
        sb.append(getFrequent(arr)).append('\n');
        sb.append(arr[n-1] - arr[0]).append('\n');
        System.out.println(sb);
    }

    private static int getFrequent(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }

        int max = 0;
        for (Integer i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i : map.keySet()) {
            if(max == map.get(i)) list.add(i);
        }

        Collections.sort(list);

        return list.size() > 1 ? list.get(1) : list.get(0);
    }
}