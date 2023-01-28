package section9;

import java.util.*;


class Athlete implements Comparable<Athlete> {

    private int height;
    private int weight;

    Athlete(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }


    public void setHeight(int height) {
            this.height = height;
            }

    public void setWeight(int weight) {
            this.weight = weight;
            }

    public int getHeight(){
            return this.height;
            }

    public int getWeight(){
            return this.weight;
            }

    public int compareTo(Athlete a){
            return a.height - this.height;
            }

    }



public class Ex1 {

    void solution(Athlete[] athletes, int N) {

        // 키 먼저 정렬하고, 맨 앞에서부터 max에 무게 최소값 저장해나아가면서, max보다 큰 애만 통과하고 걔를 max로 최신화


        Arrays.sort(athletes);
        int max = 0, cnt=0;

        for(int i=0; i<N; i++) {
            if(max < athletes[i].getWeight()){
                max = athletes[i].getWeight();
                cnt++;
            }

        }

        System.out.print(cnt);
    }

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        Ex1 T = new Ex1();

        int N = sc.nextInt();
        Athlete[] athletes = new Athlete[N];

        for(int i=0; i<5; i++) {
            athletes[i] = new Athlete(sc.nextInt(), sc.nextInt());

        }

        T.solution(athletes, N);


    }
}