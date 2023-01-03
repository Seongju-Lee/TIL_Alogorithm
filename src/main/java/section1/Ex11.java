package section1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex11 {


    public String solution(String inputStr){

        String answer = "";
        int cnt = 0;

        for(int i=0; i<inputStr.length() - 1; i++){

            if(inputStr.charAt(i) == inputStr.charAt(i+1)){
                cnt++;

            }else{
                answer += inputStr.charAt(i);
                if(++cnt > 1)
                    answer += String.valueOf(cnt);
                cnt = 0;
            }
        }




        /*

        // if - else 문에서 중복되는 부분은 맨 위로 올리고, if 문 하나만 걸어서 추가되는 부분을
        // 적어주면 가독성이 훨씬 올라감.

        if(++cnt != 1)
            answer += inputStr.charAt(inputStr.length() - 1) + String.valueOf(cnt);
        else
            answer += inputStr.charAt(inputStr.length() - 1);

        // 아래처럼 코드를 짜야 함.
         */



        answer += inputStr.charAt(inputStr.length() - 1);
        if(++cnt > 1)
            answer += String.valueOf(cnt);

        System.out.println(cnt);

        return answer;
    }




    public static void main(String[] args){

        Ex11 T = new Ex11();
        Scanner sc = new Scanner(System.in);

        System.out.println(T.solution(sc.next()));
    }
}