package section2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    public void solution(int c, int[] inputArr){

        int[] answer = new int[c];

        answer[0] = inputArr[0];
        for(int i=1; i<c; i++){
            if(inputArr[i-1] < inputArr[i]){
                answer[i] = inputArr[i];
            }
        }

        for(int i : answer){
            if(i != 0)
                System.out.print(i + " ");
        }
    }
    public static void main(String args[]){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);
        int inputCnt = sc.nextInt();
        int[] inputArr = new int[inputCnt];

        for(int i=0; i<inputCnt; i++){
            inputArr[i] = sc.nextInt();
        }

        T.solution(inputCnt, inputArr);
    }
}
