package section8;

import java.util.Scanner;


public class Ex4 {

    static int N, M;
//    static boolean[] visited;
    static int[] visited;
    void DFS(int root) {

//        System.out.println(root);
        // N: 1부터 N까지 존재
        // M: 중복을 허락하여 뽑는 횟수.
        if(root > M) {
            // 출력.
            for(int e : visited) {
                System.out.print(e + " ");
            }
            System.out.println();
        }else {

            for (int i = 1; i <= N; i++) {

                visited[root-1] = i;

                DFS(root+1);
            }
        }


    }
    public static void main(String[] args) {

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new int[M];
        T.DFS(1);

    }
}
