package basic;

import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x == p.x) return this.y - p.y;
        return this.x - p.x;
    }

}

public class ComparableEx {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];


        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);

        }

        Arrays.sort(arr);

        for(Point p : arr) {
            System.out.println(p.getX() + " " + p.getY());
        }
    }
}
