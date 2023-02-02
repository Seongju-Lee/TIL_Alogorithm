package baekjooon;
import java.util.*;

class Ex1932{

    void solution(int n, ArrayList<Integer>[] arr){
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0].get(0);
        int answer = dp[0][0];

        for(int i=1; i<n; i++){
            int size = arr[i].size();
            for(int j=0; j<size; j++){
                if(j==0) dp[i][j] = dp[i-1][j] + arr[i].get(j);
                else if(j == (size-1)) dp[i][j] = dp[i-1][size-2] + arr[i].get(j);
                else{
                    dp[i][j] =Math.max(dp[i-1][j]+arr[i].get(j) , dp[i-1][j-1]+arr[i].get(j));
                }

                if(answer < dp[i][j]) answer = dp[i][j];
            }
        }

        System.out.print(answer);



    }


    public static void main(String[] args){
        Ex1932 T = new Ex1932();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i] = new ArrayList<>();

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<(i+1); j++){
                arr[i].add(sc.nextInt());
            }
        }

        T.solution(n, arr);
    }
}