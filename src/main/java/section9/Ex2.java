package section9;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.Scanner;

class Reservation implements Comparable<Reservation>{
    private int startTime, endTime;

    public Reservation(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "startTime: " + this.startTime + ", endTime: " + this.endTime;
    }

    @Override
    public int compareTo(Reservation r) {

        /**
         *  하나 내림차순, 다른 하나도 내림차순 이건 불가능 하지만,
         *  "하나가 어떤 조건을 만족할 때, 다른 하나를 ~~식으로 정렬."
         *  은 가능하니 참고 필수!
         *
         *  해당 문제에서는 endTime이 같을 때, startTime이 올바르지 않으면 값이 틀리므로
         *  해당 경우에 startTime을 정렬하도록 설정한다.
         */
        if(r.endTime == this.endTime) return this.startTime - r.startTime;
        return this.endTime - r.endTime;
    }
}
public class Ex2 {

    /**
     * "시작"이라는 것부터 먼저 정렬 해야 한다고 고정관념이 있었음.
     * 끝나는 시간을 기준으로 잡고 진행하면 "시작"을 기준으로 잡은 것보다 반복수행이 현저히 줄어든다.
     */

    void solution(Reservation[] reservations) {

        int cnt  = 0;
        Arrays.sort(reservations);

        for(Reservation r : reservations) {
            System.out.println(r.toString());
        }

        System.out.println();

        int end = 0;
        for(Reservation r : reservations) {
            if(r.getStartTime() >= end) {
                end = r.getEndTime();
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    public static void main(String[] args) {

        Ex2 T = new Ex2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Reservation[] reservations = new Reservation[n];

        for (int i = 0; i < n; i++) {
            reservations[i] = new Reservation(sc.nextInt(), sc.nextInt());
        }

        T.solution(reservations);

    }
}
