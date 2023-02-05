package baekjooon;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1260 {

    static int[][] board;
    static boolean[] visited;
    static int n; // 정점의 개수
    void DFS(int root, int cnt) {


        System.out.print(root + " ");

        for (int i = 1; i < board[root].length; i++) {
            if(board[root][i] == 1 && !visited[i]) {

                visited[i] = true;
                DFS(i, 0);
            }
        }

    }

    void BFS(int root) {

        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        System.out.print(root + " ");
        q.offer(root);

        while (!q.isEmpty()) {

            int qSize = q.size();

            for(int i=0; i<qSize; i++) {

                int value = q.poll();

                for (int j = 1; j < board[value].length; j++) {

                    if((!visited[j]) && board[value][j] == 1) {
                        visited[j] = true;
                        System.out.print(j + " ");
                        q.offer(j);
                    }
                }

            }

        }

    }


    public static void main(String[] args) {
        Ex1260 T = new Ex1260();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 시작 번호
        visited = new boolean[1001];

        board = new int[1001][1001];
        for(int i=1; i<=m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            board[x][y] = 1;
            board[y][x] = 1;
        }

        visited[v] = true;
        T.DFS(v, 0);

        System.out.println();
        visited = new boolean[1001];
        T.BFS(v);

    }

}
