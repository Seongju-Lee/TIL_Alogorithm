package baekjooon.DfsBfs;

import java.io.*;
import java.util.*;

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Ex14940 {

    static int[][] board, answer;
    static int n, m;


    void BFS(int startX, int startY) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        int cnt=0;

        while (!q.isEmpty()) {

            int qSize = q.size();

            cnt += 1;

            for (int i = 0; i < qSize; i++) {

                Point point = q.poll();

                // 동서남북 조회
                for (int j = 0; j < 4; j++) {

                    int nx = point.getX() + xi[j];
                    int ny = point.getY() + yi[j];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 1 && answer[nx][ny] == 0) {

                        q.offer(new Point(nx, ny));


                        answer[nx][ny] = cnt;
                    }

                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        Ex14940 main = new Ex14940();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int startX = 0;
        int startY = 0;


        board = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {

                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;

                if(tmp == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }


        main.BFS(startX, startY);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++) {

                if(board[i][j] == 1 && answer[i][j] == 0) {
                    sb.append(-1 + " ");
                } else
                    sb.append(answer[i][j] + " ");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
