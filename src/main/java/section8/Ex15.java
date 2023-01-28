package section8;
import java.util.*;

public class Ex15 {

    static int n, m;
    static ArrayList<Point> pizzaArr, houseArr;
    static int[] combination;

    // 조합 DFS
//    void CombicationDFS(int L, int s) {
//
//        if(L==m) {
//            for(int x : combination) System.out.print(x +" ");
//            System.out.println();
//        }else{
//            for(int i=s; i<pizzaArr.size(); i++){
//                combination[L] = i;
//                DFS(L+1, i+1);
//            }
//        }
//    }

    static int answer = Integer.MAX_VALUE;

    void DFS(int L, int c) {
        if (L == m) {

            int sum = 0;
            for(Point p : houseArr) {

                int oneDistance = Integer.MAX_VALUE;

                for(int i : combination) {
                    oneDistance = Math.min(oneDistance, (Math.abs(p.getX() - pizzaArr.get(i).getX()) + Math.abs(p.getY() - pizzaArr.get(i).getY())));
                }
                sum += oneDistance;
            }

            if(sum < answer) answer = sum;
        }else {
            for(int i=c; i<pizzaArr.size(); i++){
                combination[L] = i;
                DFS(L + 1, i+1);
            }
        }
    }

    public static void main(String[] args) {

        Ex15 T = new Ex15();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pizzaArr = new ArrayList<>();
        houseArr = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) houseArr.add(new Point(i, j));
                else if(tmp == 2) pizzaArr.add(new Point(i, j));
            }
        }

        combination = new int[m];
        T.DFS(0, 0);

        System.out.println(answer);
    }
}

class Point {

    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}