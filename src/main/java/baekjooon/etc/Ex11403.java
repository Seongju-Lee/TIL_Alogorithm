package baekjooon.etc;

import java.util.*;
import java.io.*;

// 플로이드 와샬
class Ex11403{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {

                    if(board[i][j] == 1) continue;
                    else if(board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] i : board) {
            for(int j : i) {
                sb.append(j + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);



    }
}