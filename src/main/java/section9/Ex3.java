package section9;

import java.util.Arrays;
import java.util.Scanner;


class Time implements Comparable<Time> {

    private int time;
    private char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    /**
     * 동일한 시간이라면, 오는 시간과 가는 시간의 순서가 매우 중요하다.
     *
     */
    @Override
    public int compareTo(Time t) {
        if(this.time == t.time) return this.state - t.state;
        return this.time - t.time;
    }

    public int getTime() {
        return time;
    }

    public char getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", state=" + state +
                '}';
    }
}

public class Ex3 {


    /**
     * start부터 쭈욱 체크하다가 start또는 end라는 이벤트가 발생하면 인원 수를 그냥 갱신해주면 됨.
     * 갱신할 때 로직만 주의하면 됨.
     */

    void solution(Time[] times) {

        int cnt = 0;
        int answer = 0;

        for(Time t : times) {
            if(t.getState() == 'e')
                cnt--;
            else if(t.getState() == 's')
                cnt++;


            answer = Math.max(cnt, answer);
        }

        System.out.print(answer);
    }

    public static void main(String[] args) {

        Ex3 T = new Ex3();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Time[] times = new Time[2*N];

        for(int i=1; i<=2*N; i++) {
            int time = sc.nextInt();

            if(i%2 == 0)
                times[i-1] = new Time(time,'e');
            else times[i-1] = new Time(time,'s');
        }


        Arrays.sort(times);

        T.solution(times);
    }
}
