package baekjooon.DfsBfs;

import java.util.*;

class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

class Ex2178 {

    static int[][] board;
    static int x, y, cnt;
    static Queue<Point> q = new LinkedList<>();

    void BFS() {

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        boolean flag = true;

        while (!q.isEmpty() && flag) {


            int qSize = q.size();
            cnt += 1;


            for(int i=0; i<qSize; i++) {

                Point point = q.poll();


                if(point.getX() == x && point.getY() == y){
                    flag = false;
                    break;
                }

                for(int j=0; j<4; j++) {

                    int nx = point.getX() + xi[j];
                    int ny = point.getY() + yi[j];

                    if(nx >=0 && ny>=0 && nx<=x && ny<=y && board[nx][ny] == 1) {
                        q.offer(new Point(nx, ny));
                        board[nx][ny] = -1;
                    }
                }

            }

        }

    }

    public static void main(String[] args) {

        Ex2178 main = new Ex2178();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        board = new int[n][m];
        for(int i=0; i<n; i++) {
            String s= sc.next();

            for(int j=0; j<s.length(); j++) {
                board[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        x = n-1;
        y = m-1;

        q.offer(new Point(0, 0));
        board[0][0] = -1;
        main.BFS();
        System.out.println(cnt);

    }

}