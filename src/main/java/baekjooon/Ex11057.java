package baekjooon;
import java.util.*;

class Ex11057{

    void solution(int n){

        int[][] dp = new int[n+1][10];


        for(int i=1; i<=n; i++){

            for(int j=0; j<=9; j++){
                if(i==1 || j==0) dp[i][j] = 1;
                else{

                    for(int k=0; k<=j; k++){
                        dp[i][j] += dp[i-1][k];
                    }

                    dp[i][j] %= 10007;


                }
            }
        }

        for(int[] k : dp)
            System.out.println(Arrays.toString(k));

        int answer = 0;
        for(int i : dp[n]){
            answer += i;
        }

        System.out.println(answer);
        System.out.println(answer%10007);
    }

    public static void main(String[] args){

        Ex11057 T = new Ex11057();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        T.solution(n);
    }
}