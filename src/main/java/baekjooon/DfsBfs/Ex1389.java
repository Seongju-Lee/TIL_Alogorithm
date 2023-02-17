package baekjooon.DfsBfs;
import java.util.*;
import java.io.*;

class Ex1389 {

    static int[] answer;
    static int[] visited; // root 노드에서 각 인덱스 번호인 노드에 가는 거리.
    static ArrayList<Integer>[] list;

    void BFS(int root) {

        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;
        q.offer(root);

        while (!q.isEmpty()) {

            int qSize = q.size();

            for(int i=0; i<qSize; i++) {

                int node = q.poll();
                visited[node] = Math.min(cnt, visited[node]);

                for(int j=0; j<list[node].size(); j++) {

                    if(visited[list[node].get(j)] == Integer.MAX_VALUE)
                        q.offer(list[node].get(j));

                }


            }

            cnt += 1;
        }


    }

    public static void main(String[] args) throws IOException {

        Ex1389 main = new Ex1389();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 관계의 수


        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int minValue = Integer.MAX_VALUE;
        int a = 0;
        for(int i=1; i<=n; i++) {

            visited = new int[n+1];
            Arrays.fill(visited, Integer.MAX_VALUE);
            visited[0] = 0;

            main.BFS(i);

            // 최댓값 찾기.
            int sum = 0;

            for(int j=1; j<=n; j++) {
                sum += visited[j];
            }

            if(minValue > sum) {
                minValue = sum;
                a = i;
            }
        }

        System.out.print(a);


    }
}