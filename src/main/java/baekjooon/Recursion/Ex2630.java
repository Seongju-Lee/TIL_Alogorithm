package baekjooon.Recursion;

import java.util.*;
import java.io.*;


class Ex1230 {

    static int[][] board;

    void DFS(int size, int rowAt, int colAt, int[] answer) {

        for(int i=0; i<4; i++) {

            int row = (i/2)*size + rowAt;
            int col = (i%2)*size + colAt;

            int firstVal = board[row][col];
            boolean flag = true;

            for(int s=row; s<row+size; s++) {
                for(int k=col; k<col+size; k++) {

                    if(board[s][k] != firstVal) {
                        flag = false;
                        DFS(size/2, row, col, answer);
                        break;
                    }
                }
                if(!flag)
                    break;
            }

            if(flag) {
                answer[firstVal] += 1;
            }

        }

    }

    public static void main(String[] args) throws IOException {

        Ex1230 main = new Ex1230();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] answer = new int[2];


        int size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        for(int i=0; i<size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<size; j++) {

                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int firstVal = board[0][0];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board[i][j] != firstVal) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }

        if(!flag){
            main.DFS(size/2 ,0, 0, answer);
        } else {
            answer[firstVal] += 1;
        }

        // 결과 출력 answer
        for(int i=0; i<2; i++){
            System.out.println(answer[i]);
        }

    }
}