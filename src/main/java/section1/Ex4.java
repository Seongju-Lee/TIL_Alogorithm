package section1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {

    public ArrayList<String> solution(String[] str){

        ArrayList<String> result = new ArrayList<>();

        for(String x: str){
            System.out.println("test 중입니다: "+ x);

            String tmp = new StringBuilder(x).reverse().toString();
            result.add(tmp);
            
        }
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strArr = new String[n];


        for(int i=0; i<n; i++){

            strArr[i] = sc.next();
        }

        for(String x : strArr){
            System.out.println(x);

        }

        for(String x: T.solution(strArr)){
            System.out.println(x);
        }

    }

}
