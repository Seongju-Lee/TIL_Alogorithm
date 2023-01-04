package section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

    public void solution(int n, int[] inputA, int[] inputB){

        char[] answer = new char[n];

        for(int i=0; i<n; i++){
            if(inputA[i] == inputB[i]) answer[i] = 'D';
            else if((inputA[i] - inputB[i]) == 1 || (inputA[i] - inputB[i]) == -2) answer[i] = 'A';
            else answer[i] = 'B';
        }

        for(char c : answer){
            System.out.println(c);
        }
    }
    public static void main(String args[]){

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inputA = new int[n];
        int[] inputB = new int[n];

        for(int i=0; i<n; i++){
            inputA[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            inputB[i] = sc.nextInt();
        }

        T.solution(n, inputA, inputB);
    }
}
