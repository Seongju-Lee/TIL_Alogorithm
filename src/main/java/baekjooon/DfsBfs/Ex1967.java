package baekjooon.DfsBfs;

import java.util.*;
import java.io.*;

class Edge {

    private int parent;
    private int child;
    private int weight;

    Edge(int p, int c, int w) {
        this.parent = p;
        this.child = c;
        this.weight = w;
    }

    public int getParent() {
        return this.parent;
    }

    public int getChild() {
        return this.child;
    }

    public int getWeight() {
        return this.weight;
    }

}

class Ex1967 {

    static List<Edge>[] list;
    static int answer, one;
    static boolean[] visited;

    void DFS(int node, int weight){

        if(!list[node].isEmpty()) {

            for(int i=0; i<list[node].size(); i++) {

                int nextChild = list[node].get(i).getChild();
                int nextParent = list[node].get(i).getParent();

                if (nextChild != 0 && !visited[nextChild]) {

                    visited[nextChild] = true;
                    DFS(nextChild, weight + list[node].get(i).getWeight());
                    visited[nextChild] = false;

                } else if (nextParent != 0 && !visited[nextParent]) {

                    visited[nextParent] = true;
                    DFS(nextParent, weight + list[node].get(i).getWeight());
                    visited[nextParent] = false;

                }
            }

        }

        if(answer < weight) {
            answer = weight;
            one = node;
        }

        return;

    }

    public static void main(String[] args) throws IOException {

        Ex1967 main = new Ex1967();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<(n-1); i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[p].add(new Edge(0, c, w));
            list[c].add(new Edge(p, 0, w));
        }


        if(!list[1].isEmpty()){

            visited[1] = true;
            main.DFS(1, 0);
            visited[1] = false;

            System.out.print(answer);


            answer=0;
            visited[one] = true;
            main.DFS(one, answer);
            visited[one] = false;

            System.out.print(answer);

        }




    }
}