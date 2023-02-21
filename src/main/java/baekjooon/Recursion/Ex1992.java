package baekjooon.Recursion;

import java.util.*;

class Ex1992{

    static int[][] board;
    static int n;
    static StringBuilder sb;

    void solution(int size, int r, int c) {

        sb.append("(");

        for(int k=0; k<4; k++) {

            int rowAt = (k/2)*size + r;
            int colAt = (k%2)*size + c;

            int checkVal = board[rowAt][colAt];
            boolean flag = true;

            for(int i=rowAt; i<(rowAt+size); i++) {
                for(int j=colAt; j<(colAt+size); j++) {

                    if(board[i][j] != checkVal) {

                        flag = false;
                        solution(size/2, rowAt, colAt);
                        break;
                    }

                }
                if(!flag) break;
            }

            if(flag) {
                sb.append(checkVal);
            }

        }

        sb.append(")");
    }

    public static void main(String[] args) {

        Ex1992 main = new Ex1992();
        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();
        n = sc.nextInt();
        board = new int[n][n];


        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }

        int checkVal = board[0][0];
        boolean flag=true;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(checkVal != board[i][j]) {
                    flag=false;
                    break;
                }
            }
            if(!flag)
                break;
        }


        if(flag) {
            sb.append("(");
            sb.append(checkVal);
            sb.append(")");

        } else{

            main.solution(n/2, 0, 0);
        }

        System.out.print(sb);

    }

}