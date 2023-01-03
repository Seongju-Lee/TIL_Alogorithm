package section1;

import javax.management.MBeanRegistration;
import javax.swing.text.Style;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex10 {


    public void solution1(String inputStr, String inputChar){

        int[] distanceArr = new int[inputStr.length()];
        int beforeIdx = 0;

        for(int i=0; i<inputStr.length(); i++){
            if(inputChar.charAt(0) == inputStr.charAt(i)){

                distanceArr[i] = 0;

                for(int j = 1; j<=((i - beforeIdx)/2); j++){

                    distanceArr[beforeIdx + j] = j;
                    distanceArr[i - j] = j;

                }

                if(beforeIdx == 0 && i != 0){
                    for(int j = 1; j<=i; j++){
                        distanceArr[i-j] = j;
                    }
                }

                beforeIdx = i;
            }

            if(i == inputStr.length() - 1){
                for(int j=1; j<=(i - beforeIdx); j++){
                    distanceArr[beforeIdx + j] = j;
                }
            }
        }

        for(int i : distanceArr){
            System.out.print(i + " ");
        }

    }

    public void solution2(String inputStr, char inputChar){

        ArrayList<Integer> distanceArr = new ArrayList<>(inputStr.length());
        int d = 1000;

        for(int i=0; i<inputStr.length(); i++){

            distanceArr.add(++d);

            if(inputStr.charAt(i) == inputChar){
                distanceArr.set(distanceArr.size()-1,0);
                d = 0;
            }
        }

        d = 1000;
        for(int i=inputStr.length()-1; i>=0; i--){

            if(inputStr.charAt(i) == inputChar){
                d = 1;

            }
            if (d < distanceArr.get(i)) {
                distanceArr.set(i,d++);

            }



        }
        for(int i : distanceArr){
            System.out.print(i + " ");
        }

    }



    public static void main(String[] args){

        Ex10 T = new Ex10();
        Scanner sc = new Scanner(System.in);

        T.solution1(sc.next(), sc.next());
        T.solution2(sc.next(), sc.next().charAt(0));
    }
}