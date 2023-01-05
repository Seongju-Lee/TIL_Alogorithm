package section2;

import java.util.Scanner;

public class Ex6_2 {

    public boolean isPrime(int n){

        for(int i=2; i<n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    public void solution(int[] intArr){

//        int[] answer = new int[intArr.length];

        for(int i=0; i<intArr.length; i++){
            int num = intArr[i];
            int res = 0;
            int tmp = 0;

            while(num > 0){
                tmp = num%10; // 첫째자리
                res = res*10 + tmp;
                num = num/10;
//                System.out.println(res);

            }

            if(res != 1 && isPrime(res)) System.out.print(res + " ");

        }
    }
    public static void main(String[] args){
        Ex6_2 T = new Ex6_2();
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[sc.nextInt()];

        for(int i=0; i<intArr.length; i++){
            intArr[i] = sc.nextInt();
        }

        T.solution(intArr);
    }
}
