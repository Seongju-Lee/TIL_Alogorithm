package baekjooon.backTracking;

import java.util.*;

class Ex15654{

    static boolean[] visited;
    static void dfs(int size, int depth, int[] arr, int[] out) {

        if(depth == size) {
            for(int i : out) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {

            for(int i=0; i<arr.length; i++) {

                if(!visited[i]) {

                    visited[i] = true;
                    out[depth] = arr[i];
                    dfs(size, depth+1, arr, out);
                    visited[i] = false;

                }
            }

        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[n];
        Arrays.sort(arr);
        dfs(m, 0, arr, new int[m]);

    }
}