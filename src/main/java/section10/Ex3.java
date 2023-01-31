package section10;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

    void solution(int n, int[] arr) {

        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        int answer = 0;

        for (int i = 1; i < n; i++) {
            maxLen = 0;
            for (int j = (i-1); j >= 0; j--) {

                if ((arr[i] > arr[j]) && maxLen < dp[j] ) {
                    maxLen = dp[j];

                }
            }

            dp[i] = maxLen+1;

            if(answer < dp[i]) answer = dp[i];


        }

        System.out.println(answer);
    }

    public static void main(String[] args) {

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.solution(n, arr);

    }
}
