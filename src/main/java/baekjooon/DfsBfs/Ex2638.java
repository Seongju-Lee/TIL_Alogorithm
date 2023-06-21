package baekjooon.DfsBfs;

import java.util.*;

public class Ex2638 {

    private static boolean isBoundary(int[][] board, int n, int m, int[] cheese) {

        Queue<int[]> q = new LinkedList<>();

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        int exposure = 0;

        for (int v = 0; v < 4; v++) {

            boolean[][] visited = new boolean[n][m];

            int x = cheese[0] + xi[v];
            int y = cheese[1] + yi[v];
            if(board[x][y] != 0) continue;

            q.offer(new int[]{x, y});

            // 각 방향에 따른 bfs
            while (!q.isEmpty() && exposure < 2) {

                int size = q.size();

                for (int s = 0; s < size; s++) {

                    int[] point = q.poll();

                    if (point[0] == 0 || point[0] == (n - 1) || point[1] == 0 || point[1] == (m - 1)) {
                        exposure++;
                        q.clear();
                        break;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nx = point[0] + xi[i];
                        int ny = point[1] + yi[i];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }

                }
            }


        }

        return (exposure>=2);
    }

    private static int solution(int[][] board, int n, int m, int cheeseCnt) {

        int cnt = 0;

        while (cheeseCnt > 0) {

            // 가장자리 치즈들
            List<int[]> boundaries = new ArrayList<>();

            // 치즈 위치 목록
            for (int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {

                    if(board[i][j] == 0) continue;

                    // 각 치즈들이 가장자리인지 판단
                    int[] tmp = new int[]{i, j};
                    if (isBoundary(board, n, m, tmp)) {
                        if(cnt == 3) {
                            System.out.println("Arrays.toString(tmp) = " + Arrays.toString(tmp));
                        }
                        // 가장자리라면, boundaries에 추가
                        boundaries.add(tmp);
                    }
                }

            }

            // boundaries에 있는 치즈들 cheeses에서 제거
            for (int[] boundary : boundaries) {
                cheeseCnt--;
                board[boundary[0]][boundary[1]] = 0;
            }

            // cnt++
            System.out.println("cnt = " + cnt);
            for (int[] cheese : board) {
                System.out.println(Arrays.toString(cheese));
            }
            System.out.println();
            cnt++;


        }


        return cnt;
    }

    public static void main(String[] args) {

        // 치즈 위치들
        int cnt = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }


        System.out.println("cnt = " + solution(board, n, m, cnt));


    }
}
