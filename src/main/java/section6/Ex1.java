package section6;
import java.util.*;

public class Ex1 {


    int[] solution(int n, int[] inputArr){

        // 선택정렬

        int minIdx = 0; // 가장 작은 값
        int tmp = 0; // swap 위한 tmp값

        for(int i=0; i<n-1; i++){
            minIdx = i;
            for(int j=i+1; j<n; j++){
                if(inputArr[minIdx] > inputArr[j]) minIdx = j;
            }
            tmp = inputArr[minIdx];
            inputArr[minIdx] = inputArr[i];
            inputArr[i] = tmp;


        }

        return inputArr;
    }

    public static void main(String[] args){

        Ex1 T = new Ex1();
        Scanner sc = new Scanner(System.in);

        int[] inputArr = new int[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = sc.nextInt();
        }

        for(int i : T.solution(inputArr.length, inputArr)){
            System.out.print(i + " ");
        }

    }
}
