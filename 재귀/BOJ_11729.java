package 재귀;

import java.util.Scanner;

/**
 * BOJ_11729_S1_하노이 탑 이동 순서
 * @author mingggkeee
 * 재귀
 */

public class BOJ_11729 {
	
	static int N, count;
	static int[][] record;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

        hanoi(N, 1, 2, 3);
        sb.insert(0, (int)(Math.pow(2, N) - 1) + "\n");
        System.out.print(sb);

		sc.close();
	}
	
    public static void hanoi(int num, int from, int by, int to) {
        if(num == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            hanoi(num-1, from, to, by); // 1번에서 2번으로
            sb.append(from + " " + to + "\n");
            hanoi(num-1, by, from, to); // 2번에서 3번으로
        }
    }

}
