package section6;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {


    // 삽입정렬
    int[] solution(int n, int[] inputArr){


        for(int i=1; i<n; i++){
            int tmp = inputArr[i], j;
            for(j=i-1; j>=0; j--){

                if(tmp >= inputArr[j]) break;
                else{
                    inputArr[j+1] = inputArr[j];
                }

            }

            inputArr[j+1] = tmp;
        }
//
//        for(int i : inputArr){
//            System.out.print(i + " ");
//        }



        return inputArr;
    }

    public static void main(String[] args){

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        for(int i : T.solution(inputArr.length, inputArr)){
            System.out.print(i + " ");
        }

    }
}
