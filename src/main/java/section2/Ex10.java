package section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex10 {

    public void solution(int[][] intArr){

        int cnt = 0;

        for(int i=1; i<intArr.length-1; i++){
            for(int j=1; j<intArr.length-1; j++){
                if((intArr[i-1][j] < intArr[i][j] && intArr[i+1][j] < intArr[i][j]) &&
                        (intArr[i][j-1] < intArr[i][j] && intArr[i][j+1] < intArr[i][j])){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }

    public static void main(String[] args){
        Ex10 T = new Ex10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intArr = new int[n+2][n+2];

        for(int i=0; i<intArr.length; i++){
            for(int j=0; j<intArr.length; j++){

                if(i == 0) intArr[0][j] = 0;
                else if(i == intArr.length - 1) intArr[intArr.length-1][j] = 0;
                else if(j == 0) intArr[i][0] = 0;
                else if(j == intArr.length - 1) intArr[i][intArr.length - 1] = 0;
                else
                    intArr[i][j] = sc.nextInt();
            }
        }


        T.solution(intArr);

    }
}
