package section9;
import java.util.*;

class Ex6 {

    static int[] arr;

    public static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if(findA != findB) arr[findA] = findB;
    }

    public static int find(int a) {
        if(a == arr[a]) return arr[a];
        else return arr[a] = find(arr[a]);
    }
    public static void main(String[] args) {

        Ex6 T = new Ex6();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            union(sc.nextInt(), sc.nextInt());
        }

        System.out.println(Arrays.toString(arr));

        int a = find(sc.nextInt());
        int b = find(sc.nextInt());


        if(a == b) System.out.println("YES");
        else System.out.println("NO");

    }

}