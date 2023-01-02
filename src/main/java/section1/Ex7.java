package section1;

import java.util.Scanner;

public class Ex7 {

    // solution1에서 StringBuilder 이용한 reverse()도 for문을 수행하기에
    // 메모리를 덜 차지하는 solution2가 더 낫다고 판단 됨.

    public Boolean solution1(String inputStr){

        inputStr = inputStr.toUpperCase();
        StringBuilder sb = new StringBuilder(inputStr);

        if(inputStr.equals(sb.reverse().toString()))
            return true;
        else
            return false;
    }


    public Boolean solution2(String inputStr){

        inputStr = inputStr.toUpperCase();

        for(int i=0; i<(inputStr.length()/2); i++){

            if(!(inputStr.charAt(i) == inputStr.charAt(inputStr.length() - 1 - i)))
                return false;
        }
        return true;
    }
    public static void main(String[] args){

        Ex7 T = new Ex7();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution2(sc.next()) ? "YES" : "NO");
    }
}