package section1;

import java.util.Scanner;

public class Ex2 {

    public static String solution(String str){

        // 덧셈 연산자를 활용한 문자열 결합은 성능이 떨어짐 -> 변경이 가능한 StringBuilder사용이 더 나음
        StringBuilder sb = new StringBuilder(str);

        for(int i=0; i<sb.length(); i++){

            if(Character.isUpperCase(sb.charAt(i)))
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            else
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }


        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print(solution(sc.next()));

    }

}
