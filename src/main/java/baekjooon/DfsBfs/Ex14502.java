package baekjooon.DfsBfs;

import java.util.*;

public class Ex14502 {

    private static void bfs(int n, int m, int[][] board, int[] ans, List<int[]> virusPoints) {


        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = board[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int[] virusPoint : virusPoints) {
            q.offer(virusPoint);
        }

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        // virus 위치부터 시작해서, 감염할 곳 모두 감염시킴
        while (!q.isEmpty()) {


            int size = q.size();
            for (int s = 0; s < size; s++) {

                int[] point = q.poll();

                for (int w = 0; w < 4; w++) {

                    int nx = point[0] + xi[w];
                    int ny = point[1] + yi[w];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] == 0) {

                        tmp[nx][ny] = 2; // 감염
                        q.offer(new int[]{nx, ny});
                    }

                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(tmp[i]));
//        }

        // 감염 후, 남은 안전지대 카운트
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (tmp[i][j] == 0) {
                    safeArea++;
                }
            }
        }


        ans[0] = Math.max(ans[0], safeArea);

    }


    private static void rec(int n, int m, int row, int[][] board, int[] ans, List<int[]> virusPoints, int recCnt) {


        if (recCnt == 3) { // 재귀 카운트 3: 벽이 3군데 세워진 상태
            bfs(n, m, board, ans, virusPoints);
            return;
        }

        // 3개 씩 모든 경우의 수를 따져서 벽을 세워본다.
        for (int i = row; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(board[i][j] == 0) {

                    board[i][j] = 1;
                    rec(n, m, i, board, ans, virusPoints, recCnt+1);
                    board[i][j] = 0;
                }

            }
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> virusPoints = new ArrayList<>();

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();

                if (board[i][j] == 2) {
                    virusPoints.add(new int[]{i, j});
                }
            }
        }

        int[] ans = new int[1];
        rec(n, m, 0, board, ans, virusPoints, 0);

        System.out.println(ans[0]);

    }
}
