package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex9 {


    public void solution(int[][] intArr){

        int maxSum = 0;
        int rowSum = 0;
        int colSum = 0;
        int diagLeftgSum = 0;
        int diagRightSum = 0;


        for(int i = 0; i<intArr.length; i++){
            rowSum = 0;
            colSum = 0;
            for(int j = 0; j<intArr[i].length; j++){
                rowSum += intArr[i][j];
                colSum += intArr[j][i];
            }
            if(rowSum > maxSum) maxSum = rowSum;
            if(colSum > maxSum) maxSum = colSum;



            diagLeftgSum += intArr[i][i];
            diagRightSum += intArr[(intArr.length - 1) - i][(intArr.length - 1) - i];
        }



        if(colSum > maxSum) maxSum = colSum;
        if(diagLeftgSum > maxSum) maxSum = diagLeftgSum;
        if(diagRightSum > maxSum) maxSum = diagRightSum;


        System.out.println(rowSum + " " + colSum + " " + diagLeftgSum + " " + diagRightSum);
        System.out.print(maxSum);
    }


    public static void main(String[] args){
        Ex9 T = new Ex9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intArr = new int[n][n];

        for(int i=0; i<intArr.length; i++){
            for(int j=0; j<intArr.length; j++){
                intArr[i][j] = sc.nextInt();
            }
        }


        T.solution(intArr);

    }
}
