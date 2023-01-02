package section1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Ex6 {

    public String solution(String inputStr){
        String answer = "";

        for(int i=0; i<inputStr.length(); i++){

            // str.indexOf(c)는 문자열 str에서 문자 c가 처음으로 나오는 index를 리턴.
            if(i == inputStr.indexOf(inputStr.charAt(i)))
                answer += inputStr.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args){

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        System.out.print(T.solution(sc.next()));
    }
}