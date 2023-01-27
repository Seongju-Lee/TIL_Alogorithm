package section8;
import java.lang.reflect.Array;
import java.util.*;


public class Ex11 {

    static int[][] board;
    static int answer= Integer.MAX_VALUE;

    void BFS() {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        int[] xi = {-1, 0, 1, 0};
        int[] yi = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] value = q.poll();

            for(int i=0; i<4; i++) {
                int nx = value[0] + xi[i];
                int ny = value[1] + yi[i];

                if(nx >= 0 && ny >= 0 && nx <= 6 && ny <= 6) {

                    if(board[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        board[nx][ny] = board[value[0]][value[1]] + 1;

                        if(nx == 6 && ny == 6 && (answer > board[nx][ny])) {

//                            System.out.println("answer변천사: " + answer);
                            answer = board[nx][ny];
                        }

                    }

                }
            }

        }

        if(answer == Integer.MAX_VALUE) answer = -1;



//        for(int[] i : board) {
//            System.out.println(Arrays.toString(i));
//        }


    }

    /**
     * 1. 특정 지점에서 상-우-좌-하 모두 탐색
     * 2. 갈 수 있는 곳은 큐에 삽입.
     * 3. 큐에 있는 좌표를 꺼내서 하나씩 이동 후에, 좌표에 cnt+1값을 넣어놓음.
     * 4. 해당 좌표에서 큐가 비어질 때까지 1-2 반복
     * 5. 큐 비어지면 3-5 반복.
     *
     * 6. 마지막 6,6 좌표는 cnt가 가장 작은 값을 저장 하려고 했으나,
     *    어차피 최초에 도달하는 값 이외에 도달할 수가 없음(if([6,6] == 0))일 때만 접근 가능하기 때문에.
     *
     */
    public static void main(String[] args) {

        Ex11 T = new Ex11();
        Scanner sc = new Scanner(System.in);

        board = new int[7][7];

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                board[i][j] = sc.nextInt();
            }
        }

        T.BFS();

        System.out.print(answer);

    }
}
