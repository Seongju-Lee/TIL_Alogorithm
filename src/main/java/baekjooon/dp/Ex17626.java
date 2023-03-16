package baekjooon.dp;

import java.util.*;

public class Ex17626 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        for(int i=2; i<=n; i++) {

            int value=Integer.MAX_VALUE;

            if(Math.sqrt(i)%1 == 0)
                dp[i] = 1;
            else{
                for(int j=1; (j*j)<=i; j++) {
                    int tmp = i-(j*j);
                    value = Math.min(1+dp[tmp], value);
                    dp[i] = Math.min(dp[i], value);
                }
            }
        }

//        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        System.out.print(dp[n]);




    }
}
