package baekjooon.etc;

import java.util.*;
import java.io.*;

class Ex7662 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<t; tc++) {

            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int iCnt=0;
            int oCnt=0;

            for(int i=0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char type = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(type == 'I') {
                    map.put(n, map.getOrDefault(n, 0)+1);
                    iCnt++;
                } else {
                    if(map.size()==0) continue;

                    if(n == -1) {
                        map.put(map.firstKey(), map.get(map.firstKey())-1);
                        oCnt++;
                        if(map.get(map.firstKey()) == 0) {
                            map.remove(map.firstKey());
                        }

                    } else if(n == 1) {
                        map.put(map.lastKey(), map.get(map.lastKey())-1);
                        oCnt++;
                        if(map.get(map.lastKey()) == 0) {
                            map.remove(map.lastKey());
                        }

                    }
                }
            }
            if(iCnt <= oCnt) sb.append("EMPTY").append('\n');
            else {
                sb.append(map.firstKey() + " " + map.lastKey()).append('\n');
            }
        }
        System.out.print(sb);
    }
}