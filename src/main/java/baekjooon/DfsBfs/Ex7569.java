package baekjooon.DfsBfs;
import java.util.*;
import java.io.*;

class Point3{
    private int x;
    private int y;
    private int z;

    Point3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getZ() {return this.z;}
}

public class Ex7569{

    static int[][][] board;
    static int cnt;

    int BFS(Queue<Point3> q, int n, int m, int h) {

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        int[] zi = {1, -1};
        int answer=0;

        while(!q.isEmpty()) {

            int qSize = q.size();

            for(int i=0; i<qSize; i++) {

                Point3 p = q.poll();

                for(int j=0; j<4; j++) { // 상우하좌
                    int nx = p.getX() + xi[j];
                    int ny = p.getY() + yi[j];

                    if(nx >= 0 && ny >= 0 && nx<n && ny<m && board[p.getZ()][nx][ny]==0) {
                        board[p.getZ()][nx][ny] = 1;
                        q.offer(new Point3(nx, ny, p.getZ()));
                        cnt++;
                    }
                }

                for(int j=0; j<2; j++) { // 위, 아래
                    int nz = p.getZ() + zi[j];

                    if(nz >= 0 && nz <h && board[nz][p.getX()][p.getY()]==0) {
                        board[nz][p.getX()][p.getY()] = 1;
                        q.offer(new Point3(p.getX(), p.getY(), nz));
                        cnt++;
                    }
                }
            }
            answer+=1;

        }

        return answer-1;
    }

    public static void main(String[] args) throws IOException {

        Ex7569 main = new Ex7569();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        Queue<Point3> q = new LinkedList<>();
        int noExist =0;

        for(int k=0; k<h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {

                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) {
                        q.add(new Point3(i, j, k));
                    } else if(val == -1){
                        noExist++;
                    }

                    board[k][i][j] = val;
                }
            }
        }
        if(q.size() == n*m*h) {
            System.out.println(0);
            return;
        }

        int changeCnt = (n*m*h)-(q.size()+noExist);

        int answer = 0;
        if(q.size() != n*m*h) {
            answer = main.BFS(q, n, m, h);
        }
        if(changeCnt == cnt)
            System.out.println(answer);
        else
            System.out.println(-1);

    }
}