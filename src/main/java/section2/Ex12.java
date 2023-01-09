package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12 {

    public void solution(int[][] intArr){


        int cnt = 0;
        int i=0;

        col1: for(int j=0; j<intArr[i].length - 1; j++){

            col2: for (int k = j+1; k < intArr[i].length; k++) {

                int leftVal = intArr[i][j]; // 3
                int rightVal = intArr[i][k]; // 4


                row2: for (int s = 1; s < intArr.length; s++) {
                    int leftIdx = 100;
                    int rightIdx = 100;

                    for(int t=0; t<intArr[i].length; t++){
                        if(intArr[s][t] == leftVal){
                            leftIdx = t;
                        } else if (intArr[s][t] == rightVal) {
                            rightIdx = t;
                        }
//                        System.out.println(intArr[s][t] + ", " + leftVal +", " + rightVal);
//                        System.out.println(leftIdx + ", " + rightIdx);
                        if(leftIdx > rightIdx) break row2;
                        else if ((s == intArr.length - 1) && (t == intArr[i].length - 1)) {
                            cnt++;
                            System.out.println(leftVal +", " + rightVal);
                        }
                    }
//                        System.out.println("intArr[s][k]: " + intArr[s][k] + ", leftVal: " + leftVal + ", rightVal: " + rightVal);
//                        System.out.println("j: " + j);
//                        System.out.println("k: " + k);


                }
            }
        }
        System.out.print(cnt);

    }

    public static void main(String[] args){
        Ex12 T = new Ex12();
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
