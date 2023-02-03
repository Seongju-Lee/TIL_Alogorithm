package baekjooon;
import java.util.*;

class Ex2293{

    void solution(int[] arr, int k){

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            System.out.println(value);

            for(int j=value; j<=k; j++){


                dp[j] += (dp[j-value]);
            }

        }

        System.out.print(dp[k]);
    }

    public static void main(String[] args){

        Ex2293 T = new Ex2293();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        T.solution(arr, k);

    }
}