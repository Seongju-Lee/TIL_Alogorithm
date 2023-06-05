package baekjooon.Recursion;

import java.util.Scanner;

public class Ex10819 {

    private static void rec(int n, int[] arr, boolean[] visited, boolean even, int preVal, int sum, int[] ans, int idx) {


        for (int i=0; i<n; i++) {

            if(!visited[i]) {

                visited[i] = true;
                rec(n, arr, visited, false, arr[i], sum + (Math.abs(preVal - arr[i])), ans, i+1);
                visited[i]= false;

            }
        }

        ans[0] = Math.max(ans[0], sum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];


        // 한 노드에 대해 서브노드가 두 개가 되는 순간에,

        int[] ans = new int[1];
        for (int i = 0; i < n; i++) {

            visited[i] = true;
            rec(n, arr, visited, false, arr[i], 0, ans, 0);
            visited[i] = false;
        }


        System.out.println(ans[0]);
    }
}
