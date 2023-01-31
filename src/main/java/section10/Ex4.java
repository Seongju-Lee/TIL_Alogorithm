package section10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Block implements Comparable<Block> {

    private int width;
    private int weight;
    private int height;

    public Block(int width, int weight, int height) {
        this.width = width;
        this.weight = weight;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int compareTo(Block block) {
        return block.weight - this.weight;
    }
}
public class Ex4 {

    static int heightDp[];
    void solution(Block[] blocks, int n) {


        int maxSum = 0, answer=0;
        heightDp[0] = blocks[0].getHeight();


        for (int i = 1; i < n; i++) {

            maxSum = 0;

            for (int j = (i - 1); j >= 0; j--) {
                if((blocks[i].getWidth() < blocks[j].getWidth()) && (blocks[i].getWeight() < blocks[j].getWeight()) && (maxSum < heightDp[j])){
                    maxSum = heightDp[j];

                }
            }

            heightDp[i] = blocks[i].getHeight() + maxSum;
            if(answer < heightDp[i]) answer = heightDp[i];
        }

//        System.out.println(Arrays.toString(heightDp));
        System.out.print(answer);

    }

    public static void main(String[] args) {
        Ex4 T = new Ex4();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Block[] blocks = new Block[n];
        heightDp = new int[n];

        for (int i = 0; i < n; i++) {

            int width = sc.nextInt();
            int weight = sc.nextInt();
            int height = sc.nextInt();

            blocks[i] = new Block(width, height, weight);
            heightDp[i] = 0;
        }

        Arrays.sort(blocks);
        T.solution(blocks, n);
    }

}
