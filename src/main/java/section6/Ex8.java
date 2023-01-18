package section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex8 {

    // 이분탐색
    int solution(int n, int m, int[] inputArr){

        Arrays.sort(inputArr);
        int left = 0;
        int right = inputArr.length - 1;
        int middle = (left+right)/2;

        while (left <= right) {

            middle = (left+right)/2;

            if (inputArr[middle] == m) return middle+1;
            else if (m > inputArr[middle]) left = middle + 1;
            else if (m < inputArr[middle]) right = middle - 1;


        }




        return -1;
    }

    public static void main(String[] args){

        Ex8 T = new Ex8();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];
        int m = sc.nextInt();

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        System.out.print(T.solution(inputArr.length, m, inputArr));

    }
}
