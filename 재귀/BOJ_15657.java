package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_15657_S3_N과 M(8)
 * @author "mingggkeee"
 * 중복조합
 */

public class BOJ_15657 {
	
	static int N,M;
	static int[] nums, numbers;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums= new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combi(0,0);
		
		br.close();
		bw.flush();
		bw.close();
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
			combi(cnt+1, i);
		}
	}

}
