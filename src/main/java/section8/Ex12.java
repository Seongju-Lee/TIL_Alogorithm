package section8;

import java.util.*;

public class Ex12 {

    static int[][] board;
    static ArrayList<int[]> complete;
    static Queue<int[]> q;
    static int M,N, cnt, allCnt;

    void BFS() {

        /**
         * 1. 현재 익은 토마토의 위치에서 부터 +1 하면서 상-우-하-좌 뻗쳐 나감
         * 2. BFS ㄲ
         */

        int[] xi = {-1, 0, 1 ,0};
        int[] yi = {0, 1, 0 ,-1};



        while (!q.isEmpty() && allCnt != (M*N)) {

            int qSize = q.size();

//            System.out.println(qSize);

            for(int j=0; j<qSize; j++){

                int[] value = q.poll();

                for(int i=0; i<4; i++) {

                    int nx = value[0] + xi[i];
                    int ny = value[1] + yi[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        allCnt++;
                    }

                }
            }

            for(int[] i : board) {
                System.out.println(Arrays.toString(i));
//                System.out.println(allCnt);

            }


            cnt++;

        }

        if(allCnt < (M*N)) {
            cnt = -1;
        }



    }
    public static void main(String[] args) {

        Ex12 T = new Ex12();
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        board = new int[N][M];
        complete = new ArrayList<>();
        q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    complete.add(new int[]{i, j});
                    q.offer(new int[]{i, j});
                    allCnt++;
                }else if (board[i][j] == -1)
                    allCnt++;
            }
        }


        T.BFS();
        System.out.print(cnt);

    }
}
