package baekjooon.Map;

import java.util.*;
import java.io.*;

public class Ex18870 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            Map<Long, Integer> map = new HashMap<>();
            long[] inputArr = new long[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                long key = Integer.parseInt(st.nextToken());
                inputArr[i] = key;
                map.put(key, map.getOrDefault(key, 0)+1 );
            }

            List<Long> keyList = new ArrayList<>(map.keySet());
            Collections.sort(keyList);

            int val =0;
            Map<Long, Integer> answer = new HashMap<>();
            for(int i=0; i<keyList.size(); i++) {
                long key = keyList.get(i);
                answer.put(key, val);
//                val += map.get(key);
                val += 1;
            }


//            System.out.println("answer = " + answer);
            StringBuilder sb = new StringBuilder();
            for(long l : inputArr) {
                sb.append(answer.get(l) + " ");
            }

            System.out.print(sb);
        }
}
