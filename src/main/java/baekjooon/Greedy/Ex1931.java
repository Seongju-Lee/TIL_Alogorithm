package baekjooon.Greedy;
import java.io.*;
import java.util.*;

// 끝나는 시간 순대로 오름차순
// 마지막 끝나는 시간보다 시작시간이 같거나 크면 추가.
class Res implements Comparable<Res> {

    private int start;
    private int end;

    Res(int s, int e) {
        this.start = s;
        this.end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Res r) {
        if(r.end == this.end) {
            return this.start - r.start;
        } else {
            return this.end - r.end;
        }
    }

    public boolean equals(Res r) {

        if((r.start == this.start) && (r.end == this.end)) {
            return true;
        } else {
            return false;
        }
    }

}

class Main2 {

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Res[] arr = new Res[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Res(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(arr);
        int cnt=1;
        int lastEndTime = arr[0].getEnd();

        for(int i=1; i<n; i++) {

            if(lastEndTime <= arr[i].getStart()) {

                lastEndTime = arr[i].getEnd();
                cnt += 1;
            }

        }

        System.out.print(cnt);

    }

}