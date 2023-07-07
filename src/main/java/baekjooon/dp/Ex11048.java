package baekjooon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex11048 {

    private static int solution(int n, int m, int[][] board) {

        int[] xi = {1, 0, 1};
        int[] yi = {0, 1, 1};
        int[][] dp = new int[n][m];
        dp[0][0] = board[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int k = 0; k < 3; k++) {
                    int nx = i + xi[k];
                    int ny = j + yi[k];

                    if(nx < n && ny < m) {
                        dp[nx][ny] = Math.max(dp[i][j] + board[nx][ny], dp[nx][ny]);
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, m, board));
    }
}
