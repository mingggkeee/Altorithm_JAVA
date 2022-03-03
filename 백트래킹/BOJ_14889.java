package 백트래킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_14889_S2_스타트와 링크
 * @author mingggkeee
 * 백트래킹
 */

public class BOJ_14889 {
	
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int[][] score;
	static boolean[] numbers;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		score = new int[N+1][N+1];
		numbers = new boolean[N+1];
		
		for(int r=1; r<=N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				score[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(1,0);
		
		System.out.println(answer);
	}
	
	static void combi(int start, int cnt) {
		
		if(cnt == N/2) {
			int[] select = new int[N/2];
			int[] noSelect = new int[N/2];
			for(int i=1, j=0, k=0; i<=N; i++) {
				if(numbers[i]) {
					select[j++] = i;
				} else {
					noSelect[k++] = i;
				}
			}

			int compare = sum(select, noSelect);
			answer = Math.min(compare, answer);
			
			return;
		}
		
		for(int i=start; i<=N; i++) {
			numbers[i] = true;
			combi(i+1, cnt+1);
			numbers[i] = false;
		}
		
		
	}
	
	static int sum(int[] select, int[] noSelect) {
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=0; i<select.length; i++) {
			int r = select[i];
			
			for(int j=0; j<select.length; j++) {
				int c = select[j];
				sum1 += score[r][c];
			}
			
		}
		
		for(int i=0; i<noSelect.length; i++) {
			int r = noSelect[i];
			
			for(int j=0; j<noSelect.length; j++) {
				int c = noSelect[j];
				sum2 += score[r][c];
			}
			
		}
		
		
		return Math.abs(sum1-sum2);
		
	}

}
