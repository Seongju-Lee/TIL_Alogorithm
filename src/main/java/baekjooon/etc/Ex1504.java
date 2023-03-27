package baekjooon.etc;

import java.io.*;
import java.util.*;

public class Ex1504 {

    static int size;
    static final int INF=200_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        size=n;
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // v1과 v2에 대한 모든 경로 다익스트라 적용.
        int answer1 = 0;
        answer1 += dijkstra(1, v1, list);
        answer1 += dijkstra(v1, v2, list);
        answer1 += dijkstra(v2, n, list);

        //
        int answer2 = 0;
        answer2 += dijkstra(1, v2, list);
        answer2 += dijkstra(v2, v1, list);
        answer2 += dijkstra(v1, n, list);

        int answer = Math.min(answer1, answer2 );

        if(answer1 >=  INF || answer2 >= INF)
            System.out.println("answer = " + "-1");
        else
            System.out.println("answer = " + answer);
    }


    static int dijkstra(int root, int n, ArrayList<int[]>[] list) {

        int[] dis = new int[size + 1];
        Arrays.fill(dis, INF);
        dis[root] = 0;

        Queue<int[]> pQ = new PriorityQueue<>((i1, i2) -> {return i1[1]-i2[1];});

        pQ.offer(new int[]{root, 0});

        while (!pQ.isEmpty()) {

            int[] node = pQ.poll();

            for (int[] arr : list[node[0]]) {

                if(dis[arr[0]] > (dis[node[0]]+arr[1])) {
                    dis[arr[0]] = dis[node[0]]+arr[1];
                    pQ.offer(arr);
                }
            }
        }


        return dis[n];
    }

}
