package baekjooon.etc;

import java.io.*;
import java.util.*;

class Ex11286 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>((i1, i2) -> {

            int abs1 = Math.abs(i1);
            int abs2 = Math.abs(i2);

            if(abs1 == abs2) return i1 - i2;
            else return abs1 - abs2;

        });
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(br.readLine());

            if(val == 0) {
                if(pQ.isEmpty())
                    sb.append(0);
                else{
                    sb.append(pQ.poll());
                }

                sb.append('\n');
            } else {
                pQ.offer(val);
            }
        }


        System.out.println(sb);
    }
}