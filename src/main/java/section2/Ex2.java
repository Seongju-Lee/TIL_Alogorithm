package section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {

    public void solution(int[] inputArr){

        ArrayList answer = new ArrayList();
        int maxHeight = inputArr[0];
        answer.add(new Integer(inputArr[0]));

        for(int i=1; i<inputArr.length; i++){
            if(inputArr[i] > maxHeight){
                answer.add(new Integer(inputArr[i]));
                maxHeight = inputArr[i];
            }

        }


        System.out.print(answer.size());
    }
    public static void main(String args[]){

        Ex2 T = new Ex2();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];
        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        T.solution(inputArr);
    }
}
