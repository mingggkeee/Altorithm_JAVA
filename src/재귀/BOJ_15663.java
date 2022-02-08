package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * BOJ_15663_S2_N과 M(9)
 * @author "mingggkeee"
 * 순열
 */

public class BOJ_15663 {
	
	static int N,M;
	static int[] nums, numbers;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums= new int[N];
		numbers = new int[M];
		isSelected = new boolean[N+1];
		answer = new LinkedHashSet<String>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		permu(0);
		answer.forEach(System.out::println);
		br.close();

	}
	
	public static void permu(int cnt) throws IOException{
		if (cnt == M) {
			sb = new StringBuilder();
			for(int i : numbers) {
				sb.append(i+" ");
			}
			answer.add(sb.toString());
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			
			
			if(isSelected[i]) {
				continue;
			}
			
			numbers[cnt] = nums[i];
			isSelected[i] = true;
			
			permu(cnt+1);
			isSelected[i] = false;
		}
	}

}
