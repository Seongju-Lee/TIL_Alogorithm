package section6;

import java.util.*;

class map {

    int x, y;

    map(int x, int y){
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString(){
        return x + " " + y;
    }

}
public class Ex7 {


//    map[] mapSort(map[] inputArr){
//
//    }

    ArrayList<Integer> solution(int n, map[] inputArr){

        ArrayList<Integer> answer = new ArrayList<>();

        /*
        선택 정렬로 진행.
        동일한 값이 나오면 y를 비교해서 인덱스를 바꿀지 말지 결정.
         */

        for(int i=0; i<n-1; i++){
            int minIdx = i;

            for(int j=i+1; j<n; j++){

                if(inputArr[minIdx].x > inputArr[j].x) minIdx = j;
                else if (inputArr[minIdx].x == inputArr[j].x) {
                    if(inputArr[minIdx].y > inputArr[j].y) minIdx = j;
                }
            }


            map tmp = inputArr[minIdx];
            inputArr[minIdx] = inputArr[i];
            inputArr[i] = tmp;

        }

        for(map m : inputArr){
            System.out.println(m);
        }

        return answer;
    }

    public static void main(String[] args){

        Ex7 T = new Ex7();
        Scanner sc = new Scanner(System.in);

        map[] inputArr = new map[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = new map(sc.nextInt(), sc.nextInt());
        }

        T.solution(inputArr.length, inputArr);

    }
}
