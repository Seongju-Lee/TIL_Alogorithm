package baekjooon.Recursion;

import java.util.*;
import java.io.*;

class Ex9735 {

//    static String[] outs;
//    static int answer;
//    static void DFS(int depth, int n, List<String> keyList, int size, Map<String, ArrayList<String>> map) {
//
//        if(depth == keyList.size()) {
//            answer+= size;
//        } else {
//            DFS(depth+1, n, keyList, map.get(keyList.get(depth)).size()*size, map);
//            DFS(depth+1, n, keyList, size, map);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {

            int answer=1;

            Map<String, ArrayList<String>> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String value = st.nextToken();
                String key = st.nextToken();

                ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(value);

                map.put(key, list);
            }

            for (String key: map.keySet()) {

                System.out.println(map.get(key));
                answer *= (map.get(key).size()+1); // 조합: 합이 아니라 곱...
            }
            sb.append(answer-1).append('\n');
        }

        System.out.print(sb);
    }
}