package baekjooon.Recursion;

import java.util.Scanner;

public class Ex14889 {



    private static int diffSum(boolean[] visited, int n, int[][] board) {

        int startTeam = 0;
        int linkTeam = 0;


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += board[i][j];
                    startTeam += board[j][i];
                } else if(!visited[i] && !visited[j]){
                    linkTeam += board[i][j];
                    linkTeam += board[j][i];
                }
            }

        }

        return Math.abs(startTeam - linkTeam);
    }

    private static void rec(int[][] board, boolean[] visited, int[] ans, int n, int idx, int m , int cnt) {

        if(cnt == m) {
            int diff = diffSum(visited, n, board);
            ans[0] = Math.min(ans[0], diff);
        }

        for (int i = idx; i < n; i++) {

            visited[i] = true;
            rec(board, visited, ans, n, i+1, m, cnt+1);
            visited[i] = false;

        }



    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = (n/2); // 팀 당 인원 수

        int[][] board = new int[n][n];
        boolean[] visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        rec(board, visited, ans, n, 0, m, 0);


        System.out.print(ans[0]);
    }
}
