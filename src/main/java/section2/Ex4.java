package section2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {

    public void solution(int n){

        int[] seq = new int[n];

        for(int i=0; i<seq.length; i++){
            if(i == 0 || i==1)
                seq[i] =1;
            else{
                seq[i] = seq[i-2] + seq[i-1];
            }
            System.out.print(seq[i] + " ");
        }
    }
    public static void main(String args[]){

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.solution(n);
    }
}
