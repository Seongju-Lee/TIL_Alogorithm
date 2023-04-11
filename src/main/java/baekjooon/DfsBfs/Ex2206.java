package baekjooon.DfsBfs;
import java.util.*;
import java.io.*;


class Point4{

    public int x;
    public int y;
    public int z;

    public Point4(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
public class Ex2206 {


    static int bfs(int[][] board, int n, int m) {


        Queue<Point4> q = new LinkedList<>();
        q.offer(new Point4(0, 0, 1));

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        int ans = 1;

        if(n-1 == 0 && m-1 == 0) {
            if(board[0][0] == 1) return -1;
            else return 1;
        }

        board[0][0] = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                Point4 p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + xi[i];
                    int ny = p.y + yi[i];

                    if (nx == (n - 1) && ny == (m - 1)) return ans+1;

                    // 네 방향 탐색
                    // 1이라면
                    // z== 0이라면 이동불가.
                    // z== 1이라면 z=0 하고, 이동.
                    // 0이라면 이동.

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                        if (p.z == 1 && board[nx][ny] == 1) {
//                            System.out.println("nx + \", \" + ny = " + nx + ", " + ny);
//                            board[nx][ny] = ans+1;
                            q.offer(new Point4(nx, ny, 0));
                        } else if (board[nx][ny] == 0) {
//                            System.out.println("nx + \", \" + ny = " + nx + ", " + ny + ", " + p.z);
//                            board[nx][ny] = ans+1;
                            q.offer(new Point4(nx, ny, p.z));
                        }

//                        if(board[nx][ny] == '2' && p.z == 1) {
//                            System.out.println("nx + \", \" + ny = " + nx + ", " + ny + ", " + p.z);
//                            q.offer(new Point4(nx, ny, 0));
//                        }
                    }
                }
            }
            ans++;

        }

        return -1;

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) { // 이차원 배열로써, 입력.
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }


        System.out.println( "answer = " + bfs(board, n, m));


    }
}
