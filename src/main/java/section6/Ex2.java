package section6;

import java.util.Scanner;

public class Ex2 {


    int[] solution(int n, int[] inputArr){

        // 버블정렬
       int maxIdx = 0;
       int tmp = 0;

        for(int i=1; i<=n; i++){

            for(int j=0; j<(n-i); j++){

                if(inputArr[j] > inputArr[j+1]){
                    tmp = inputArr[j+1];
                    inputArr[j+1] = inputArr[j];
                    inputArr[j] = tmp;
                }

            }
        }


        return inputArr;
    }

    public static void main(String[] args){

        Ex2 T = new Ex2();
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
