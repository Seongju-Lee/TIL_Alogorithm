package baekjooon.DfsBfs;
import java.util.*;


public class Ex2644 {


    static List<Integer>[] list;
    static boolean[] visited;
    static int answer=-1;

    void DFS(int node, int des, int cnt) {

        int size = list[node].size();

        if(node == des) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < size; i++) {

            int nextNode = list[node].get(i);

            if(!visited[nextNode]) {

                visited[nextNode] = true;
                DFS(nextNode, des, cnt+1);
                visited[nextNode] = false;
            }

        }



    }

    public static void main(String[] args) {

        Ex2644 main = new Ex2644();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n + 1];

        int x = sc.nextInt(); // 기준이 될 부모노드
        int y = sc.nextInt(); // 찾아야할 자식 노드

        int m = sc.nextInt(); // 부모-자식 관계의 수


        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }


        visited[x] = true;
        main.DFS(x, y, 0);
        visited[x] = false;


        System.out.println(answer);
    }
}
