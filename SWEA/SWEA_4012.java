package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA_4012_요리사
 * @author mingggkeee
 * 조합
 */

public class SWEA_4012 {
	
	static int T, N, K;
	static int [][] score;
	static int answer;
	static int[] numbers;
	static int compare;
	static boolean [] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			score = new int[N][N];
			K = N/2;	// 선택할 식재료 개수
			numbers = new int[K];
			for(int r=0;r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					score[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			combination(0, 0);
			
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	
	public static void combination(int cnt, int start) {
		
		if(cnt==K) {
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			isSelected = new boolean[N];
			int food1 = 0;
			int food2 = 0;
			// 1번 요리
			for(int i : numbers) {
				list1.add(i);
				isSelected[i] = true;
			}

			for(int r=0; r<list1.size(); r++) {
				int R = list1.get(r);
				for(int c=0; c<list1.size(); c++) {
					int C = list1.get(c);
					food1 += score[R][C];
				}
			}
			
			// 2번요리
			
			for(int i=0; i<N; i++) {
				if(isSelected[i] == false) {
					list2.add(i);
				}
			}
			
			for(int r=0; r<list2.size(); r++) {
				int R = list2.get(r);
				for(int c=0; c<list2.size(); c++) {
					int C = list2.get(c);
					food2 += score[R][C];
				}
			}	
			int temp = Math.abs(food1 - food2);
			
			answer = Math.min(temp, answer);
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}
	
}
