package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12_2 {

    public void solution(int[][] intArr){


        int colCnt = intArr[0].length;
        int rowCnt = intArr.length;
        int cnt = 0;

        for(int i=0; i<colCnt; i++){
            for(int j=i+1; j<colCnt; j++){

                int leftVal = intArr[0][i];
                int rightVal = intArr[0][j];

                row: for(int k=1; k<rowCnt; k++){


                    for(int s=0; s<colCnt; s++){

                        if(intArr[k][s] == rightVal) break row;
                        else if (intArr[k][s] == leftVal) {

                            if ((k == rowCnt-1)) {
                                cnt++;
//                                System.out.println(leftVal + ", " + rightVal);
                            }else break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);

    }

    public static void main(String[] args){
        Ex12_2 T = new Ex12_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 시험 횟수
        int[][] intArr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                intArr[i][j] = sc.nextInt();
            }
        }

        T.solution(intArr);

    }
}
