package section1;

import java.util.Scanner;

public class Ex9 {


    public int solution1(String inputStr){
        return Integer.valueOf(inputStr.replaceAll("[^0-9]",""));
    }

    public int solution2(String inputStr){

        // 아스키 넘버 이용해서 접근해보기.
        return 0;
    }

    public static void main(String[] args){

        Ex9 T = new Ex9();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution1(sc.nextLine()));
    }
}