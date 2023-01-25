package section8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Ex6 {

    static int[] answer;
    static boolean[] visited;
    void DFS(int idx, int N, int M, int[] arr) {

        if(idx == M){

            for(int E : answer) {
                System.out.print(E + " ");
            }
            System.out.println();
        } else {

            for(int i=0; i<N; i++) {
                if(!visited[i]) {

                    answer[idx] = arr[i];
                    visited[i] = true;
                    DFS(idx+1, N, M, arr);
                    visited[i] = false;
                }
            }

        }

    }
    public static void main(String[] args) {

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 주어진 원소의 개수
        int M = sc.nextInt(); // 중복을 허용하지 않고, 뽑는 횟수.

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[N];
        answer = new int[M];
        T.DFS(0, N, M, arr);

    }
}
