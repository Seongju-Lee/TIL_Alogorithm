package baekjooon;
import java.util.*;

class Ex1463{

    void solution(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;



        for(int i=2; i<=n; i++){

            dp[i] = dp[i-1]+1;
            if(i%3 == 0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
            if(i%2 == 0) dp[i] = Math.min(dp[i/2]+1, dp[i]);

            // 이런 식으로 if - else if - else로 나누게 되면 어떤 최소값을 놓치게 될 지 모른다.
            // 때문에 위의 식처럼 세 가지 경우의 수에 대해 모두 계산한 후, 최솟값을 지정해야 한다.
/*

            if(i%3 == 0) dp[i] = Math.min(dp[i/3]+1, dp[i-1]+1);
            else if(i%2 == 0) dp[i] = Math.min(dp[i/2]+1, dp[i-1]+1);
            else
                dp[i] = dp[i-1]+1;
*/

        }



        System.out.print(dp[n]);

    }

    public static void main(String[] args){
        Ex1463 T = new Ex1463();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}