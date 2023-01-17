package section6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ComparableMap implements Comparable {

    int x, y;

    ComparableMap(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Object o) {


        // 오름차순으로 정렬
        // 내림차순이면 반대로 빼면 됨.
        ComparableMap c = (ComparableMap) o;

        if (this.x == c.x) return this.y - c.y;
        return this.x - c.x;

    }


}
public class Ex7_2 {

    void solution(int n, ComparableMap[] inputArr){

        ArrayList<ComparableMap> list = new ArrayList<>();

        for(ComparableMap c : inputArr){
            list.add(c);
        }

        Collections.sort(list);

        for(ComparableMap m : list){
            System.out.println(m);
        }

    }

    public static void main(String[] args){

        Ex7_2 T = new Ex7_2();
        Scanner sc = new Scanner(System.in);

        ComparableMap[] inputArr = new ComparableMap[sc.nextInt()];

        for(int i=0; i<inputArr.length; i++){
            inputArr[i] = new ComparableMap(sc.nextInt(), sc.nextInt());
        }

        T.solution(inputArr.length, inputArr);

    }
}
