package baekjooon.UnionFind;
import java.util.*;


public class Ex1043 {




        static int[] parent;

        public static void union(int a, int b) {

            int findA = find(a);
            int findB = find(b);

            if(findA != findB)
                parent[findA] = findB;
        }

        public static int find(int a) {

            if(parent[a] == a) return parent[a];
            else return parent[a] = find(parent[a]);
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // 사람 수
            int m = sc.nextInt(); // 파티 수
            boolean[] visited = new boolean[n+1];

            // union-find의 각 원소의 부모 저장.
            parent = new int[n+1];
            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }

            // 진실을 알고 있는 사람.
            int k = sc.nextInt();
            boolean[] knowP = new boolean[n+1];
            for(int i=1; i<=k; i++) {
                int tmp = sc.nextInt();
                knowP[tmp] = true;
                visited[tmp] = true;
            }

            List<Integer>[] list = new ArrayList[m];
            for(int i=0; i<m; i++) {
                int tmp = sc.nextInt();
                list[i] = new ArrayList<>();

                for(int j=0; j<tmp; j++) {

                    int know = sc.nextInt();
                    list[i].add(know);
                    if(j > 0) {
                        union(list[i].get(j-1), know);
                    }
                }

            }

            //진실 아는 사람들의 최상단 노드(한 파티에 있던 그룹)을 visited true로 변경
            for(int i=1; i<=n; i++) {
                if(knowP[i]) {
                    System.out.println("i = " + i);
                    visited[find(i)] = true;
                }
            }


            // 각 파티인 list 돌면서, 첫 번째 사람의 최상단 노드의 visited값이 false인지 확인
            int answer = 0;

            for (int i=0; i<m; i++) {
                if(!visited[find(list[i].get(0))]) {
                    answer++;
                }
            }


            System.out.println(answer);
        }

}
