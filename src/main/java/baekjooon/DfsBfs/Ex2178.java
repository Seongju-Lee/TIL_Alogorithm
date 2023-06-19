package baekjooon.DfsBfs;

import java.util.*;


class Ex2178 {

    private static int bfs(int n, int m, char[][] board) {

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        int dis = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {

                int[] point = q.poll();
                if (point[0] == (n-1) && point[1] == (m-1)) {
                    q.clear();
                    break;
                }

                for (int i = 0; i < 4; i++) {

                    int nx = point[0] + xi[i];
                    int ny = point[1] + yi[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == '1' && !visited[nx][ny]) {

                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});

                    }
                }

            }

            dis++;

        }

        return dis;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            board[i] = input.toCharArray();
        }

        System.out.println(bfs(n, m, board));

    }
}