package section8;
import java.util.*;

public class Ex10 {

    static int[][] board;
    static int cnt;

    void DFS(int x, int y){

        int[] xi = {0,1,0,-1};
        int[] yi = {-1,0,1,0};

        if(x == 6 && y == 6) {
            cnt++;
            return;
        }

        for(int i=0; i<4; i++) {

            int nx = x + xi[i];
            int ny = y + yi[i];


            if(nx >= 0 && ny >= 0 && nx <=6 && ny <=6) {

                if(board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    DFS(nx, ny);
                    board[ny][nx] = 0;
                }
            }
        }




        /**
         * 상-우-하-좌 탐색 위해서 for문 4번 수행.
         * 1. 탐색 했을 때 0이면 1로 변환하면서 해당 방향으로 이동.
         * 2. DFS(x좌표, y좌표)
         *
         */

    }
    public static void main(String[] args) {

        Ex10 T = new Ex10();
        Scanner sc = new Scanner(System.in);

        board = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[0][0] = 1;
        T.DFS(0,0);

        System.out.println(cnt);
    }
}
