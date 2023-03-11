package baekjooon.DfsBfs;
import java.io.*;
import java.util.*;

public class Ex14500 {

    static int answer=0;
    static void dfs(int x, int y, int[][] board, boolean[][] visited, int depth, int n, int m, int sum) {

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

//        System.out.println( x + ", " + y +" ==> " + sum);

        if(depth == 4) {
            answer = Math.max(answer, sum);


        } else {

            for(int i=0; i<4; i++) {

                int nx = x + xi[i];
                int ny = y + yi[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]) {

                    // 일일이 조건 네 가지 if문을 구성 안해도, 아래 로직으로도 구현 가능.
//                    if(depth == 2) {
//                        visited[nx][ny] = true;
//                        dfs(x, y, board, visited, depth+1, n,m, sum+board[nx][ny]);
//                        visited[nx][ny] = false;
//                    }
//
//                    visited[nx][ny] = true;
//                    dfs(nx, ny, board, visited, depth+1, n, m, sum+board[nx][ny]);
//                    visited[nx][ny] = false;

                    visited[nx][ny] = true;
                    dfs(nx, ny, board, visited, depth+1, n, m, sum+board[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    static int Solution(int[][] board, int n, int m) {
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                visited[i][j] = true;
                dfs(i, j, board, visited, 1, n, m, board[i][j]);
                visited[i][j] = false;
                // 안되는 모양 한 가지를 4 회전 한 것들.

                if(j != 0 && j != (m-1) && i !=(n-1))
                    answer = Math.max(answer, board[i][j]+board[i+1][j]+board[i][j-1]+board[i][j+1]);
                if(i!=0 && j!=0 && i !=(n-1))
                    answer = Math.max(answer, board[i][j]+board[i][j-1]+board[i-1][j]+board[i+1][j]);
                if(i!=0 && j!=0 && j != (m-1))
                    answer = Math.max(answer, board[i][j]+board[i-1][j]+board[i][j-1]+board[i][j+1]);
                if(i != 0 && j != (m-1) && i !=(n-1))
                    answer = Math.max(answer, board[i][j]+board[i][j+1]+board[i-1][j]+board[i+1][j]);
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(Solution(board, n, m));
    }
}