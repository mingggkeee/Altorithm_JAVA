package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 햄버거 다이어트
 * 순열/조합문제
 */

public class SWEA_5215 {
	static int N, L;
	static int[][] info;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			info = new int[N][2];
			answer = 0;
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				info[n][0] = Integer.parseInt(st.nextToken());
				info[n][1] = Integer.parseInt(st.nextToken());
			}
			
			generateSubset(0, 0, 0);
			System.out.println("#"+i+" "+answer);
		}
		
	}
	public static void generateSubset(int cnt, int score, int cal) {	// 부분 집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		if(cal > L) {
			return;
		}
		if(cnt==N) {
			answer = Math.max(answer, score);
			return;
		}
		generateSubset(cnt+1, score+info[cnt][0], cal+info[cnt][1]);
		generateSubset(cnt+1, score, cal);
	}
}
/*
public class SWEA_5215 {
	
	static int N, L, calories, scores, answer;
	static int[] score, calorie;
	static boolean[] isSelected;
	
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			calorie = new int[N];
			isSelected = new boolean[N];
			
			for(int m=0; m<N; m++) {
				st = new StringTokenizer(br.readLine());
				score[m] = Integer.parseInt(st.nextToken());
				calorie[m] = Integer.parseInt(st.nextToken());
			}
			
			answer = Integer.MIN_VALUE;
			generateSubset(0);
			
			System.out.println("#"+i+" "+answer);
		}
	}
		
		public static void generateSubset(int cnt) {	// 부분 집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
			
			if(cnt == N){
				scores = 0;
				calories = 0;
				for(int i=0; i<N; i++) {
					if(isSelected[i]) {
						scores += score[i];
						calories += calorie[i];
					}
				}
				if(calories<=L) {
					answer = Math.max(scores, answer);
				}
				return;
			}
			// 현재 원소를 선택
			isSelected[cnt] = true;
			generateSubset(cnt+1);
			// 현재 원소를 비선택
			isSelected[cnt] = false;
			generateSubset(cnt+1);
		}
		

		
		
}
*/