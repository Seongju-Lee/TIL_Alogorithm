package section1;

import java.util.Scanner;

public class Ex12 {


    public String solution(int inputInt, String inputStr){

        String s = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inputInt*7; i+=7){

            s = inputStr.substring(i,i+7);
            s = s.replaceAll("#", "1").replaceAll("\\*","0");
            int digit = Integer.parseInt(s, 2);

            sb.append((char) digit);
        }


        return sb.toString();
    }




    public static void main(String[] args){

        Ex12 T = new Ex12();
        Scanner sc = new Scanner(System.in);

        System.out.println(T.solution(sc.nextInt() ,sc.next()));
    }
}