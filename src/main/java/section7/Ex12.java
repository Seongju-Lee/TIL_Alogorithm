package section7;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12 {

    /*
    1번 정점부터 N번 정점까지 가는 모든 경로의 가지수를 출력.

     */

    static int n;
    static int[][] graph;
    static boolean[] vistied;
    static int cnt = 0;
    void DFS(int current) {

//        System.out.println("현재 cnt: " + cnt);

        if(current == n){

            for(int i=0; i<vistied.length; i++){
                if(vistied[i]) System.out.print((i+1) + " ");

            }
            System.out.println();
            cnt++;
//            vistied[current-1] = false;
        }
        else{

            for(int i=0; i<n; i++){
                if(!vistied[i] && graph[current-1][i] == 1){
                    vistied[i] = true;

                    DFS(i+1);
                    vistied[i] = false;
                }
            }


        }

//        vistied[current-1] = false;


    }

    public static void main(String[] args){

        Ex12 T = new Ex12();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt(); // 간선의 수
        graph = new int[n][n];

        for(int i=0; i<m; i++){

                graph[sc.nextInt()-1][sc.nextInt()-1] = 1;

        }

        for(int[] arr : graph){
            System.out.println(Arrays.toString(arr));
        }

        vistied = new boolean[n];
        vistied[0] = true;
        T.DFS(1);
//        System.out.println(Arrays.deepToString(graph));

        System.out.println(cnt);
    }

}
