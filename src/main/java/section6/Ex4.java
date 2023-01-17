package section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex4 {

    int[] solution(int s, int n, int[] inputArr){


        /*
        s: 캐시메모리 크기
        n: 작업 개수

        inpuArr에서 하나씩 뽑아서 answer에 삽입.
        1. contain 이용서 answer에 있는 원소인지 판단 후,
           있으면 해당 원소를 맨 앞으로 당기고 다 한칸씩 뒤로!
           없으면 삽입.

         */

        int[] answer = new int[s];
        boolean isInclusion = false;
        int tmp = -1;


        for (int i : inputArr) {

            for(int j=0; j<answer.length; j++){
                if(i != 0 && answer[j] == i){

                    isInclusion = true;
                    tmp = j;
                    break;
                }
            }

            if(isInclusion){
                // 1 ~ tmp(s)까지 반복하면서 s-1 -> s 작업 수행 후,
                for(int t=tmp; t>=1; t--){
                    answer[t] = answer[t-1];
                }
                isInclusion = false;
            }else{
                // // 1 ~ 끝(s)까지 반복하면서 s-1 -> s 작업 수행 후,
                for(int t=answer.length-1; t>=1; t--){
//                    System.out.println(Arrays.toString(answer));
                    answer[t] = answer[t-1];
                }
            }
            // answer[tmp]를 0번 인덱스로 옮기는 작업 수행
            answer[0] = i;
//            System.out.println(Arrays.toString(answer));
//            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args){

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int[] inputArr = new int[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        for(int i : T.solution(s, inputArr.length, inputArr)){
            System.out.print(i + " ");
        }

    }
}
