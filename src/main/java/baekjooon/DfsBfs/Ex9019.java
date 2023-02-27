package baekjooon.DfsBfs;

import java.util.*;
import java.io.*;

class Ex9019{

    static String answer;
    static Map<Integer, StringBuilder> map; // visited 및 현재 D,S,L,R 상태 저장용도.
    static Queue<Integer> q;
    static String search(int expected) {

        while(!q.isEmpty()){

            int value = q.poll();
            int[] valueArr = new int[4];

            valueArr[0] = value/1000;
            valueArr[1] = (value - valueArr[0]*1000)/100;
            valueArr[2] = (value - ((valueArr[0]*1000)+(valueArr[1]*100)))/10;
            valueArr[3] = (value - ((valueArr[0]*1000)+(valueArr[1]*100) + (valueArr[2]*10)));



            // D
            int dVal = (value*2)%10_000;
            if(map.get(dVal) == null){
                StringBuilder tmp = new StringBuilder();
                tmp.append(map.get(value));
                map.put(dVal, tmp.append('D'));
                q.offer(dVal);
                if(dVal == expected) break;
            }

            // S
            int sVal = (value-1);
            if(value == 0)
                sVal = 9999;
            if(map.get(sVal) == null) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(map.get(value));
                map.put(sVal, tmp.append('S'));
                q.offer(sVal);
                if(sVal == expected) break;
            }

            // L
            StringBuilder s = new StringBuilder();
            s.append(valueArr[1]).append(valueArr[2]).append(valueArr[3]).append(valueArr[0]);
            int lVal = Integer.parseInt(s.toString());
            if(map.get(lVal) == null){
                StringBuilder tmp = new StringBuilder();
                tmp.append(map.get(value));
                map.put(lVal, tmp.append('L'));
                q.offer(lVal);
                if(lVal == expected) break;
            }

            // R
            s = new StringBuilder();
            s.append(valueArr[3]).append(valueArr[0]).append(valueArr[1]).append(valueArr[2]);
            int rVal = Integer.parseInt(s.toString());
            if(map.get(rVal) == null){
                StringBuilder tmp = new StringBuilder();
                tmp.append(map.get(value));
                map.put(rVal, tmp.append('R'));
                q.offer(rVal);
                if(rVal == expected) break;
            }

        }

        return map.get(expected).toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.offer(a);
            map = new TreeMap<>();
            map.put(a, new StringBuilder());
            sb.append(search(b)).append('\n');
            t--;
        }
        System.out.print(sb);
    }
}