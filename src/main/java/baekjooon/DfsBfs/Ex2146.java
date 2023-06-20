package baekjooon.DfsBfs;

import java.util.*;

public class Ex2146 {

    private static int bfs(int n, int[][] board, int x, int y, int min, int curIsland) {

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int dis = 0;
        while (!q.isEmpty()) {

            if(dis > min) break; // 이미 최소 거리가 아니면 더 이상 탐색이 필요 없음

            int size = q.size();
            for (int s = 0; s < size; s++) {

                int[] point = q.poll();

                if (board[point[0]][point[1]] != 0 && board[point[0]][point[1]] != curIsland) {
                    return dis-1;
                }

                for (int i = 0; i < 4; i++) {

                    int nx = point[0] + xi[i];
                    int ny = point[1] + yi[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && board[nx][ny] != curIsland) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }

                }

            }
            dis++;
        }

        return Integer.MAX_VALUE;

    }

    private static void findBoundary(int n, int[][] board, int x, int y, int islandNum) {

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        // 주위에 0이 하나라도 있으면 큐에 추가
        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {

                int[] point = q.poll();
                for (int i = 0; i < 4; i++) {

                    int nx = point[0] + xi[i];
                    int ny = point[1] + yi[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = islandNum;
                        q.offer(new int[]{nx, ny});
                    }
                }

            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int islandNum = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 1) {
                    board[i][j] = islandNum;
                    findBoundary(n, board, i, j, islandNum);
                    islandNum++;
                }
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(board[i][j] == 0) continue;

                int dis = bfs(n, board, i, j, ans, board[i][j]);
                ans = Math.min(dis, ans);
            }
        }

        System.out.println(ans);

    }
}
