package baekjooon.bruteForce;

import java.util.*;

public class Ex15684 {


    private static int climbLadder(int[][] board, int input, int h) {

        int floor = 1;
        int cur = input; // 현재 위치한 세로줄의 번호

        while (floor <= h) {

            if(board[floor][cur] == 1) {
                cur++;
            } else if(board[floor][cur-1] == 1) {
                cur--;
            }

            floor++;

        }


        return cur;
    }


    // rowLadder: 설치 가능한 가로 줄의 개수
    // n: 세로줄의 개수
    // h: 총 1층부터 h층까지 존재
    // cnt: 현재까지 설치한 가로줄 개수
    private static void rec(int[][] board, int n, int h, int rowLadder, int x, int cnt) {

        if (cnt == rowLadder) {

            boolean b = true;

            // 1부터 n까지 차례대로 사다리타기 진행
            for (int i = 1; i <= n; i++) {
                int output = climbLadder(board, i, h);

                if(i != output) {
                    b = false;
                    break;
                }

            }

            if(b) {
                System.out.println(rowLadder);
                System.exit(0);
                return;
            }

            return;
        }

        for (int i = x; i <= h; i++) {
            for (int j = 1; j < n; j++) { // 열은 1부터 해야함 (행이 바뀌면 처음부터 해야 하므로.)

                if (board[i][j] == 1 || board[i][j-1] == 1) {
                    continue;
                }

                board[i][j] = 1;
                rec(board, n, h, rowLadder, i, cnt+1);
                board[i][j] = 0;

            }
        }



    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 세로 선 개수 : 마지막 세로선 번호: n
        int m = sc.nextInt(); // 가로 선 개수
        int h = sc.nextInt(); // 가로선 추가 가능헌 라인: 마지막 가로선 번호: h


        int[][] board = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); // h중, a번째 점선
            int b = sc.nextInt(); // b ~ b+1 가로선 연결

            board[a][b] = 1;
        }

        // 2차원 배열을 돌아가면서 설치 (본인 or 왼쪽이 1이 아닌 곳만 설치 가능)
        for (int i = 0; i <= 3; i++) {
            rec(board, n, h, i, 1, 0);
        }

        System.out.println(-1);

    }
}
