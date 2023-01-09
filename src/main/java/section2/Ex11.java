package section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex11 {

    public void solution(int[][] intArr){

        int colCnt = 5;
        int rowCnt = intArr.length;
//        int[] sum = new int[rowCnt];

        int maxIdx = Integer.MIN_VALUE;
        int maxCnt = Integer.MIN_VALUE;
        int cnt = 0;

        for(int i=0; i<rowCnt; i++){
            cnt = 0;
            for(int j=0; j<rowCnt; j++){
                for(int k=0; k<colCnt; k++){
                    if(intArr[i][k] == intArr[j][k]){
//                        sum[i] += 1;
                        cnt += 1;
                        break;
                    }
                }
            }
            if(cnt > maxCnt){
                maxCnt = cnt;
                maxIdx = i;
            }
        }

//        System.out.println(Arrays.toString(sum));
//        int maxNum = Integer.MIN_VALUE;
//        int maxIdx = Integer.MIN_VALUE;
//
//        for(int i=0; i<sum.length; i++){
//            if(maxNum < sum[i]){
//                maxNum = sum[i];
//                maxIdx = i;
//            }
//        }
        System.out.print(maxIdx+1);
    }

    public static void main(String[] args){
        Ex11 T = new Ex11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intArr = new int[n][5];

        for(int i=0; i<intArr.length; i++){
            for(int j=0; j<5; j++){
                intArr[i][j] = sc.nextInt();
            }
        }

        T.solution(intArr);

    }
}
