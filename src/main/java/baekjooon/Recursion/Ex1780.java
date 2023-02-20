package baekjooon.Recursion;

import java.util.*;
import java.io.*;

class Ex1780 {

    static int[][] board;
    static Map<Integer, Integer> map = new HashMap<>();

    void solution(int n, int rowAt, int colAt) {


        for(int i=0; i<9; i++) {

            boolean flag = true;

            int row = ((i/3)*n) + rowAt;
            int col = ((i%3)*n) + colAt;

            int f = board[row][col];

            Loop: for(int s=row; s<row+n; s++) {
                for(int k=col; k<col+n; k++) {

                    if(board[s][k] != f) {
                        solution(n/3 , row, col);
                        flag = false;
                        break Loop;
                    }
                }

            }

            if(flag)
                map.put(f, map.getOrDefault(f, 0)+1);


        }


    }

    public static void main(String[] args) throws IOException {

        Ex1780 main = new Ex1780();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map.put(-1, 0);
        map.put(0, 0);
        map.put(1, 0);

        int f = board[0][0];
        boolean go = false;


        Loop: for(int i=0; i<n; i++) {

            for(int j=0; j<n; j++) {
                if(board[i][j] != f) {
                    go = true;
                    break Loop;
                }
            }
        }


        if(go)
            main.solution(n/3 , 0, 0);
        else {
            map.put(f, 1);
        }


        for(int i : map.keySet()) {

            System.out.println(map.get(i));

        }


    }

}
