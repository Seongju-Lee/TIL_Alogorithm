package section1;

import java.util.Scanner;

public class Ex2 {

    public static String solution(String str){

        // 문자열 안에 문자를 변경하기 위해 StringBuffer를 사용하였지만,
        // 그냥 String s = ""; 이라고 리터럴로 만들어서 만들면 메모리 낭비도 덜 됨.
        // s += toLowerCase() 이런 식으로 하던가, 아스키코드 이용해서 변환하면 더 쉬움.
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
