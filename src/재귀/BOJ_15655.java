package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_15655_S3_N과 M(6)
 * @author "mingggkeee"
 * 조합
 */

public class BOJ_15655 {
	
	static int N,M;
	static int[] numbers, nums;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combi(0, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void combi(int cnt, int start) throws IOException{
		if(cnt==M) {
			for(int i : numbers) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = nums[i];
			combi(cnt+1, i+1);
		}
	}
}
