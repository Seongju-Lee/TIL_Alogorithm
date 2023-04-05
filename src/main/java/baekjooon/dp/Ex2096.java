package baekjooon.dp;
import java.io.*;
import java.util.*;

public class Ex2096 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        int[][] minBoard = new int[n][3];
//        int[][] maxBoard = new int[n][3];
        int[][] board = new int[n][3];

        for (int i = 0; i < n; i++) { // 입력.
            StringTokenizer st = new StringTokenizer(br.readLine());

            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());

        }

        //==solution==//

        int[] minDp = board[0].clone();
        int[] maxDp = board[0].clone();

        for (int i = 1; i < n; i++) {


            int min0 = board[i][0]+Math.min(minDp[0], minDp[1]);
            int min1 = board[i][1]+Math.min((Math.min(minDp[0], minDp[1])), minDp[2]);
            int min2 = board[i][2]+Math.min(minDp[1], minDp[2]);
            minDp[0] = min0;
            minDp[1] = min1;
            minDp[2] = min2;


            int max1 = board[i][0]+Math.max(maxDp[0], maxDp[1]);
            int max2 = board[i][1]+Math.max((Math.max(maxDp[0], maxDp[1])), maxDp[2]);
            int max3 = board[i][2]+Math.max(maxDp[1], maxDp[2]);

            maxDp[0] = max1;
            maxDp[1] = max2;
            maxDp[2] = max3;
        }
        System.out.print(Math.max(maxDp[0] , (Math.max(maxDp[1], maxDp[2]))) + " ");
        System.out.print(Math.min(minDp[0] , (Math.min(minDp[1], minDp[2]))));

        

    }
}
