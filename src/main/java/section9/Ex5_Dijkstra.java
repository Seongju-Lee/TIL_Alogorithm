package section9;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 다익스트라 알고리즘
 * 입력값
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 */

class Edge implements Comparable<Edge> {

    private int vertex;
    private int cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost; // Priority Queue에서 poll을 할 때, 최소값부터 빼내기 위해 compareTo를 사용한 기본정렬 적용.
    }
}
public class Ex5_Dijkstra {

    static int n, m;
    static LinkedList<Edge>[] graph;
    static int[] dis;

    void solution(int v) {
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0)); // 초기값 세팅
        dis[v] = 0;

        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll(); // compareTo() 오버라이딩 덕에 최소값(가중치)이 뽑힘.

            int currentV = tmp.getVertex();
            int currentC = tmp.getCost();

            if(currentC > dis[currentV]) continue;
            if(!graph[currentV].isEmpty()) {
                for (Edge e : graph[currentV]) {
                    if (dis[e.getVertex()] > (currentC + e.getCost())) {
                        dis[e.getVertex()] = (currentC + e.getCost());
                        pQ.offer(new Edge(e.getVertex(), dis[e.getVertex()]));

                    }
//                    System.out.println(Arrays.toString(dis));
                }
            }

        }



    }

    public static void main(String[] args) {
        Ex5_Dijkstra T = new Ex5_Dijkstra();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점의 수
        m = sc.nextInt(); // 간선의 수

        graph = new LinkedList[n+1];
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE); // dis배열 값 초기화
        System.out.println(Arrays.toString(graph));

        for(int j=0; j<n+1; j++) {
            graph[j] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Edge(b, c));
//            System.out.println("graph1 size: " + Arrays.toString(graph));

        }

        T.solution(1);

        for(int i=2; i<dis.length; i++) {
            if(dis[i] == Integer.MAX_VALUE)  System.out.println(i + ": impossible");
            else System.out.println(i + ": " +dis[i]);
        }
    }
}
