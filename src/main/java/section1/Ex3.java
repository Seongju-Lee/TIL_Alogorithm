package section1;

import org.example.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

    public String solution(String str){

        String result = "";
        int maxLength = Integer.MIN_VALUE;
        String[] strArr = str.split(" ");
        for(String s : strArr){

            if(s.length() > maxLength){
                result = s;
                maxLength = s.length();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner inputStr = new Scanner(System.in);
        Ex3 T = new Ex3();

        System.out.println(T.solution(inputStr.nextLine()));


    }

}
