package section8;

import java.util.Arrays;
import java.util.Scanner;

public class Ex13 {

    static int[][] board;
    static int N, cnt;

    void DFS(int i, int j) {

        int[] xi = {-1, -1, 0, 1, 1, 1, 0 ,-1};
        int[] yi = {0, 1, 1, 1, 0, -1, -1, -1};

        board[i][j] = 2;


        if(cnt == 15)
            System.out.println(i + ", " +j);

        for(int k=0; k<8; k++) {
            int nx = i + xi[k];
            int ny = j + yi[k];


            if(nx >= 0 && ny >= 0 && nx < N && ny < N && (board[nx][ny] == 1)) {
                DFS(nx, ny);
            }
        }




    }
    /**
     * 1이 나오는 지점에서 섬 하나당 DFS를 돌려야 할 듯.
     * 즉, for문을 N*N번 돌리면서 1이 나올 때 해당 지점이 포함된 섬을 DFS돌려서 찾아낸 뒤 모두 2로 바꿔 놓음.
     *
     */

    public static void main(String[] args) {
        Ex13 T = new Ex13();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        // 전체 for문
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {

                if(board[i][j] == 1) {
                    T.DFS(i, j);
                    cnt++;

                }
            }
        }

        System.out.print(cnt);
    }
}
