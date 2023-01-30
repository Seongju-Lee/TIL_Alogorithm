import java.util.*;

class Edge implements Comparable<Edge> {

    private int start;
    private int end;
    private int weight;

    public int getStart() { return this.start; }
    public int getEnd() {return this.end; }
    public int getWeight() {return this.weight; }

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

public class Ex7 {

    static int[] states;

    static void union(int a, int b){
        int findA = a;
        int findB = b;

        if(findA != findB) states[findA] = findB;
    }

    static int find(int a){
        if(a == states[a]) return states[a];
        else return states[a] = find(states[a]);
    }


    public static void main(String[] args){

        Ex7 T = new Ex7();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); // 도시의 개수
        int e = sc.nextInt(); // 간선

        int answer = 0;

        List<Edge> list = new ArrayList<>();

        // 연결상태 배열
        states = new int[v+1];
        for(int i=1; i<=v; i++){
            states[i] = i;
        }

        for(int i=0; i<e; i++){
            list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);


        for(Edge edge : list){

            int start = edge.getStart();
            int end = edge.getEnd();
            int weight = edge.getWeight();

            if(find(start) != find(end)){
                System.out.println(edge.toString());
                union(start, end);
                answer += weight;
            }
        }

        System.out.print(answer);

    }
}