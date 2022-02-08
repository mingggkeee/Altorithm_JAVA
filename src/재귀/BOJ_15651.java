package 재귀;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * BOJ_15651_S3_N과 M(3)
 * @author "mingggkeee"
 * 중복순열
 */
public class BOJ_15651{
	
	static int n,m;
	static int[] numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];
		
		permu(0);
		
		sc.close();
		bw.flush();
		bw.close();
	}
	
	public static void permu(int cnt) throws IOException {
		if(cnt == m) {
			for(int i : numbers) {
				bw.write(i+" ");
			}
			bw.write("\n");;
			return;
		}
		
		for(int i=1; i<=n; i++) {
			numbers[cnt] = i;
			permu(cnt+1);
		}
	}

}
