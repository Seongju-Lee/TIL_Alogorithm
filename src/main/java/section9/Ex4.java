package section9;

import java.util.*;

class Lecture implements Comparable<Lecture> {

    private int pay;
    private int day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    public int getPay() {
        return pay;
    }

    public int getDay() {
        return day;
    }

    public int compareTo(Lecture lecture) {
        return lecture.day - this.day;
    }

}

public class Ex4 {

    void solution(Lecture[] lectures) {

        int current = lectures[0].getDay();
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < lectures.length; i++) {

            if (lectures[i].getDay() != current) {
                for (int j = 0; j < (current - lectures[i].getDay()); j++) {
                    if(!pQ.isEmpty())
                        answer += pQ.poll();
                }
                current = lectures[i].getDay();

            }

            pQ.offer(lectures[i].getPay());

        }

        while(current != 0){

            current--;
            answer += pQ.poll();
        }

        System.out.print(answer);

    }

    public static void main(String[] args) {

        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            lectures[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lectures);

        T.solution(lectures);
    }

}
