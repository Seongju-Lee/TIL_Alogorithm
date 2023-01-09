package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex8 {


    public void solution(int[] intArr){

        int[] answer = new int[intArr.length];
        int count  = 1;

        for(int i =0; i<intArr.length; i++){

            for(int j=0; j<intArr.length; j++){
                if(intArr[i] < intArr[j]) count += 1;
            }
            answer[i] = count;
            count = 1;
        }

        for(int i : answer){
            System.out.print(i + " ");
        }





       /*
       * 5
            87 89 92 100 76

       * */


    }


    public static void main(String[] args){
        Ex8 T = new Ex8();
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[sc.nextInt()];

        for(int i=0; i<intArr.length; i++){
            intArr[i] = sc.nextInt();
        }
        T.solution(intArr);

    }
}
