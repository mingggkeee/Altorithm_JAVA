package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * BOJ_15666_S2_N과 M(12)
 * @author "mingggkeee"
 * 중복 조합
 */

public class BOJ_15666 {
	static int N,M;
	static int[] nums, numbers;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static LinkedHashSet<String> answer;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		numbers = new int[M];
		
		answer = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combi(0, 0);
		
		sb = new StringBuilder();
		for(String str : answer) {
			sb.append(str+"\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
	
	public static void combi(int cnt, int start) {
		if(cnt==M) {
			sb = new StringBuilder();
			for(int i : numbers) {
				sb.append(i + " ");
			}
			answer.add(sb.toString());
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = nums[i];
			combi(cnt+1, i);
		}
	}

}
