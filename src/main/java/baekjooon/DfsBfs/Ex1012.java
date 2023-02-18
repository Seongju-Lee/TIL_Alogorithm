package baekjooon.DfsBfs;

import java.util.*;
import java.io.*;


class Ex1012 {
    // 테스트케이스 개수만큼 main함수에 for문 돌림
    // for문 안에 solution 메소드 실행

    static int[][] board;
    static int[] yi = {0, 1, 0, -1};
    static int[] xi = {-1, 0, 1, 0};
    static int n,m, cnt;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void DFS(int x, int y) {

        board[x][y] = -1;

        for(int k=0; k<4; k++) {

            int nx = x + xi[k];
            int ny = y + yi[k];

            if(nx >=0 && ny>=0 && nx<m && ny<n && board[nx][ny] == 1) {

                DFS(nx, ny);
            }

        }
    }

    void solution() {

        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                if(board[i][j] == 1){
                    DFS(i, j);
                    cnt++;
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        Ex1012 main = new Ex1012();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            board = new int[m][n];  // m행 n열

            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
            }

            main.solution();

            bw.write(String.valueOf(cnt) + " ");
            bw.newLine();
            cnt=0;
        }

        br.close();
        bw.flush();
        bw.close();

    }



}