package baekjooon;

import java.util.*;

class Ex1149{


    void solution(int n, int[][] arr){

        int minValue = Integer.MAX_VALUE;
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {

                if(j == 0)
                    dp[i][j] = Math.min(dp[i-1][1] + arr[i][j], dp[i-1][2] + arr[i][j]);
                else if(j==1)
                    dp[i][j] = Math.min(dp[i-1][0] + arr[i][j], dp[i-1][2] + arr[i][j]);
                else if(j==2)
                    dp[i][j] = Math.min(dp[i-1][0] + arr[i][j], dp[i-1][1] + arr[i][j]);

            }

            System.out.println(Arrays.toString(dp[i]));
        }

        minValue = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(minValue);
    }



    public static void main(String[] args){

        Ex1149 T = new Ex1149();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();

            }
        }


        T.solution(n, arr);


    }
}