package section2;

import java.util.Scanner;

public class Ex7 {


    public void solution(int[] intArr){

        int sum = 0;
        int jum = 0;

        for(int i=0; i<intArr.length; i++){
            if(intArr[i] == 1){
                jum += 1;
                sum += jum;
            }else
                jum = 0;
        }

        System.out.println(sum);

    }


    public static void main(String[] args){
        Ex7 T = new Ex7();
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[sc.nextInt()];

        for(int i=0; i<intArr.length; i++){
            intArr[i] = sc.nextInt();
        }
        T.solution(intArr);

    }
}
