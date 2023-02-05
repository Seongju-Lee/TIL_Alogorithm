package baekjooon.backTracking;
import java.util.*;

/**
 * 순열 구하기 (중복 X)
 */
public class Ex15649 {

    static int n, m;
    static int[] arr, out;
    static boolean[] visited;

    void solution(int depth) {

        if (depth == m) {
            // 출력
            for (int i = 0; i < m; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();

        } else {

            for (int i = 1; i <= n; i++) {

                if(!visited[i]) {

                    visited[i] = true;
                    out[depth] = i;
                    solution(depth+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Ex15649 T = new Ex15649();
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt(); // 주어진 자연수 1 ~ n
        m = sc.nextInt(); // 나열할 수의 개수

        arr = new int[n+1];
        out = new int[m];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        T.solution(0);
    }
}
