package section8;
import java.util.*;

public class Ex10 {

    static int answer = 0;

    void DFS(int[][] grid, int nx, int ny, int vec) {

        int[] xi = {0, 1, 0, -1};
        int[] yi = {-1, 0, 1, 0};

        if (ny == 7 && nx == 7) {
//            System.out.println("answer: ");
            answer++;
        }

        for (int i = 0; i < 4; i++) {

            int x = ny + yi[i];
            int y = nx + xi[i];

            if (grid[y][x] == 0 && x>=1 && x<=7 && y>=1 && y<=7) {
//                System.out.println(ny + ", " + nx + ", i: " + i);
                grid[y][x] = 1;
                DFS(grid, x, y, i);
                grid[y][x] = 0;
            }

        }
    }

        public static void main (String[] args) {

            Ex10 T = new Ex10();
            Scanner sc = new Scanner(System.in);

            int[][] grid = new int[9][9];

            for (int i = 0; i <= 8; i++) {
                for (int j = 0; j <= 8; j++) {

                    if (i == 0 || i == 8 || j == 0 || j == 8)
                        grid[i][j] = 1;
                    else
                        grid[i][j] = sc.nextInt();
                }
            }

            T.DFS(grid, 1, 1, 0);

            System.out.println(answer);
        }
    }


