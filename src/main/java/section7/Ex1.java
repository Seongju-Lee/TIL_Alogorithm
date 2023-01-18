package section7;

import java.util.Scanner;

public class Ex1 {

    int solution(int n){


        if(n ==  1) return 1;
        else{
            return n*solution(n-1);

        }
    }

    public static void main(String[] args){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        System.out.println(T.solution(sc.nextInt()));

    }
}
