package baekjooon;
import java.util.*;

class Ex11052{

    void solution(int[] arr){

        int[] dp = new int[arr.length];
        dp[0] = 0;

        for(int i=1; i<arr.length; i++){

            // i원, arr[i]: 장 수
            int cnt = arr[i];

            for(int j=i; j<dp.length; j++){

                dp[j] = Math.max(dp[j-i]+cnt, dp[j]);

            }
        }

        System.out.print(dp[dp.length-1]);

    }


    public static void main(String[] args){

        Ex11052 T = new Ex11052();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }

        T.solution(arr);
    }
}