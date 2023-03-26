package baekjooon.etc;

import java.util.*;
import java.io.*;

class Ex1238{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1; // 목적지: 마지막에 [i][x]+[x][i]용으로 사용.

        ArrayList<int[]>[] list1 = new ArrayList[n];
        ArrayList<int[]>[] list2 = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());

            list1[x].add(new int[]{y, t});
            list2[y].add(new int[]{x, t});
        }

        int[] dis1 = dijkstra(list1, r);
        int[] dis2 = dijkstra(list2, r);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(i != r)
                answer = Math.max(answer, dis1[i] + dis2[i]);
        }

        System.out.print(answer);

    }

    static int[] dijkstra(ArrayList<int[]>[] list, int x) {


        Queue<int[]> pQ = new PriorityQueue<>((i1, i2) -> {return (i1[1]-i2[1]);});

        pQ.offer(new int[]{x, 0});

        boolean[] visited = new boolean[list.length];
        int[] dis = new int[list.length];
        Arrays.fill(dis, 1000000);
        dis[x] = 0;

        while (!pQ.isEmpty()) {

            int[] min = pQ.poll();

            for (int[] l : list[min[0]]) {
                if (!visited[l[0]] && (dis[min[0]] + l[1]) <= dis[l[0]]) {
                    dis[l[0]] = dis[min[0]] + l[1];
                    pQ.offer(l);
                }
            }
        }

        return dis;
    }
}