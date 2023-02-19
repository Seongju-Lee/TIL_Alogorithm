package baekjooon.Map;

import java.util.*;
import java.io.*;


class Ex1764{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(br.readLine(), 1);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        List<String> list = new ArrayList<>();

        for(int i=0; i<m; i++) {

            String name = br.readLine();
            int value = map.getOrDefault(name, 0);

            if(value == 1) {
                cnt += 1;
                list.add(name);
            }
        }

        Collections.sort(list);


        for(String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(cnt);
        System.out.print(sb);



    }

}