package baekjooon.etc;
import java.util.*;
import java.io.*;


public class Ex1167 {


    static int[] dijkstra(ArrayList<int[]>[] list, int node, int size) {

        int[] dis = new int[size + 1];
        Arrays.fill(dis, 100_000_000_0);
        dis[node] = 0;

        Queue<int[]> pQ = new PriorityQueue<>((i1, i2) -> {
            return i1[1] - i2[1];
        });

        pQ.offer(new int[]{node, 0});

        boolean[] visited = new boolean[size + 1];
        while (!pQ.isEmpty()) {

            int[] min = pQ.poll(); // [1, 0]

            if(!visited[min[0]]) {

                visited[min[0]] = true;

                for (int[] nextNode : list[min[0]]) { // [1, 0]


                    if(dis[nextNode[0]] > (dis[min[0]] + nextNode[1])) {
                        dis[nextNode[0]] = (dis[min[0]] + nextNode[1]);
                        pQ.offer(nextNode);
//                        System.out.println("Arrays.toString(min) = " + Arrays.toString(min));
//                        System.out.println("Arrays.toString(nextNode) = " + Arrays.toString(nextNode));
                    }
                }
            }
        }

        int val = 0;
        int maxNode = 0;
        for (int i = 1; i < dis.length; i++) {
            if(dis[i] > val) {
                val = Math.max(dis[i], val);
                maxNode = i;
            }
        }

        System.out.println("Arrays.toString(dis) = " + Arrays.toString(dis));
        return new int[]{maxNode, val};

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] list = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < v; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {

                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;

                int b = Integer.parseInt(st.nextToken());
                list[idx].add(new int[]{a, b});
            }
        }

        int[] node = dijkstra(list, 1, v);
        node = dijkstra(list, node[0], v);


        System.out.println("answer = " + node[1]);

    }

}
