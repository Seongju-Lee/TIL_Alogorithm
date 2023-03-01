package baekjooon.DfsBfs;

import java.util.*;
import java.io.*;

class Ex10026 {

    static boolean[][] visited;

    static void DFS(int x, int y, int n, char[][] board) {

        visited[x][y] = true;
        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        char value = board[x][y];

        for(int k=0; k<4; k++) {
            int nx = x+xi[k];
            int ny = y+yi[k];

            if(nx >=0 && ny >= 0 && nx <n && ny<n && !visited[nx][ny] && board[nx][ny] == value ) {
                DFS(nx, ny, n, board);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }
        visited = new boolean[n][n];
//        visited[0][0] = true;

        StringBuilder sb = new StringBuilder();

        int answer=0;
        for(int i=0; i<n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    DFS(i, j, n, board);
                    flag = true;
                }
                if(flag) {
                    answer += 1;
                    flag = false;
                }
            }
        }

        sb.append(answer).append(" ");



        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
            Arrays.fill(visited[i], false);
        }


        answer=0;
        for(int i=0; i<n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    DFS(i, j, n, board);
                    flag = true;
                }
                if(flag) {
                    answer += 1;
                    flag = false;
                }
            }
        }

        sb.append(answer);
        System.out.print(sb);

    }
}