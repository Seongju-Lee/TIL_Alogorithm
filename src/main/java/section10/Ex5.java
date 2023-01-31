package section10;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {

    void solution(int n, int[] arr, int m) {

        int[] dp = new int[m+1];
//        dp[1] = 1;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {

                dp[j] = Math.min(dp[j], dp[j - arr[i]]+1);

            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.print(dp[m]);

    }


    public static void main(String[] args) {
        Ex5 T = new Ex5();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        T.solution(n, arr, m);
    }
}