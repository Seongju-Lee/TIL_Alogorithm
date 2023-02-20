package baekjooon.etc;

import java.io.*;
import java.util.*;

class Ex1927{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {

            int val = Integer.parseInt(br.readLine());

            if(val == 0){
                if(q.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(q.poll()).append('\n');
                }

            } else {
                q.offer(val);
            }

        }

        System.out.print(sb);



    }

}