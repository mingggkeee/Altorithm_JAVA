package 백트래킹;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ_14888_S1_연산자 끼워넣기
 * @author mingggkeee
 * 백트래킹
 * 덧셈 : 0, 뺄셈 : 1, 곱셈 : 2, 나눗셈 : 3
 */

public class BOJ_14888 {
	
	static int N;
	static int[] numbers;
	static int[] operation;
	
	static int[] oper;
	static int[] selected;
	static boolean[] isVisited;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		operation = new int[4];
		oper = new int[N-1];
		selected = new int[N-1];
		isVisited = new boolean[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0, j=0; i<4; i++) {
			int count = Integer.parseInt(st.nextToken());
			operation[i] = count;
			for(int k=0; k<count; k++) {
				oper[j++] = i;
			}
		}
		
		combi(0,0);
		
		System.out.println(max);
		System.out.println(min);
	
	}
	
	static void combi(int start, int cnt) {
		
		if(cnt == N-1) {
			oper(selected);
			return;
		}
		
		for(int i=0; i<oper.length; i++) {
			
			if(!isVisited[i]) {
				selected[cnt] = oper[i];
				isVisited[i] = true;
				combi(i, cnt+1);
				isVisited[i] = false;
			}
			
		}
		
		
	}
	
	static void oper(int[] selected) {
		
		int compare = numbers[0];

		for(int i=1; i<N; i++) {
			
			int oper = selected[i-1];
			if(oper==0) {
				
				compare += numbers[i];
				
			} else if(oper==1) {
				
				compare -= numbers[i];
				
			} else if(oper==3) {
				
				if(compare < 0) {
					
					int temp = Math.abs(compare);
					temp /= numbers[i];
					compare = -temp;
					
				}
				else {
					compare /= numbers[i];
				}
				
			} else {
				compare *= numbers[i];
			}
			
			
		}
		
		min = Math.min(compare, min);
		max = Math.max(compare, max);
		
	}
	

}
