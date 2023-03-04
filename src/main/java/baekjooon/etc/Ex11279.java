package baekjooon.etc;

import java.util.*;
import java.io.*;

class Ex11279{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>((i1, i2) -> {return i2-i1;});
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {

            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(q.isEmpty()) sb.append(0);
                else sb.append(q.poll());
                sb.append('\n');
            } else {
                q.offer(x);
            }


        }
        System.out.print(sb);
    }
}