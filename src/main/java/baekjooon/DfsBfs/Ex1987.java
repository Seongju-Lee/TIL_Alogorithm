package baekjooon.DfsBfs;

import java.util.Scanner;

public class Ex1987 {

    private static final int[] XI = {-1, 0, 1, 0};
    private static final int[] YI = {0, 1, 0, -1};

    private static void dfs(int[] ans, char[][] board, boolean[][] visited, boolean[] isVisited, int x, int y, int dis) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {

            int nx = x + XI[i];
            int ny = y + YI[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            char nc = board[nx][ny];
            if (!visited[nx][ny] && !isVisited[nc - 'A']) {

//                visited[nx][ny] = true;
                isVisited[nc - 'A'] = true;
                dfs(ans, board, visited, isVisited, nx, ny, dis+1);
//                visited[nx][ny] = false;
                isVisited[nc - 'A'] = false;
            }
        }


        ans[0] = Math.max(ans[0], dis);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        String[] tmp = new String[r];
        for (int i = 0; i < r; i++) {
            tmp[i] = sc.next();
        }

        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = tmp[i].toCharArray();
        }

        int[] ans = new int[1];
        boolean[] isVisited = new boolean[26];
        boolean[][] visited = new boolean[r][c];
        isVisited[board[0][0] - 'A'] = true;
//        visited[0][0] = true;

        dfs(ans, board, visited, isVisited, 0, 0, 1);
        System.out.println(ans[0]);

    }
}
