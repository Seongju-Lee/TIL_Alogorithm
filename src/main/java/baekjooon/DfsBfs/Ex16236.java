package baekjooon.DfsBfs;
import java.util.*;
import java.io.*;

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

public class Ex16236 {

    static int solution(int[][] board, int n, Position pos, Map<Integer, Integer> map) {

        int answer=0;
        int shark=2;
        int exp = 0;
        int possibleEat = map.getOrDefault(1, 0); // shark 레벨업 할 때마다, key+1의 값 더해준다.

        boolean[][] visited = new boolean[n][n];
        Queue<Position> q = new LinkedList<>();

        visited[pos.getX()][pos.getY()] = true;
        q.offer(new Position(pos.getX(), pos.getY()));

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};
        int dis=0;

        while (true) {

            if(possibleEat == 0 || q.isEmpty()) break;
            int qSize = q.size();

            Queue<Position> pQ = new PriorityQueue<>((p1, p2) -> {
                if(p1.getX() == p2.getX()) return p1.getY()-p2.getY();
                else return p1.getX() - p2.getX();
            });

            for(int t=0; t<qSize; t++) {
                pQ.offer(q.poll());
            }

            int pQSize = pQ.size();
            for(int s=0; s<pQSize; s++) {

                boolean flag = true;
                Position p = pQ.poll();
                int cx = p.getX();
                int cy = p.getY();

                if (board[cx][cy] != 0 && board[cx][cy] < shark) { // 먹으면 된다.

                    answer += dis;
                    dis = 0;
                    board[cx][cy] = 0;
                    exp += 1;
                    possibleEat -= 1;

                    if (exp == shark) {
                        shark += 1;
                        exp = 0;
                        possibleEat += map.getOrDefault(shark - 1, 0);
                    }

                    map.put(board[cx][cy], map.getOrDefault(board[cx][cy], 1) - 1);
                    if (map.get(board[cx][cy]) == 0) {
                        map.remove(board[cx][cy]);
                    }
                    q.clear();
                    visited = new boolean[n][n];
                    flag = false;

                }

                for (int i = 0; i < 4; i++) {
                    int nx = cx + xi[i];
                    int ny = cy + yi[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && board[nx][ny] <= shark) {
                        visited[nx][ny] = true;
                        q.offer(new Position(nx, ny));
                    }
                }
                if (!flag) break;
            }
            dis+=1;
        }

        return answer;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        Position pos = new Position(0, 0);
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 9) {
                    pos.setX(i);
                    pos.setY(j);
                    tmp=0;
                }else if(tmp != 0)
                    map.put(tmp, map.getOrDefault(tmp, 0)+1);
                board[i][j] = tmp;
            }
        }
        System.out.print(solution(board, n, pos, map));
    }
}