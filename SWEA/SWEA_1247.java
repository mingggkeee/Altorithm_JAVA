package SWEA;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA_1247_D5_최적경로
 * @author mingggkeee
 *
 */

public class SWEA_1247 {
	
	static int T, N;
	static int answer;
	static int [][] location;
	static int startR, startC, endR, endC;
	
	static boolean isVisited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());	// 고객 수
			location = new int[N][2];	// 좌표 위치 담을 배열
			isVisited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			// 시작 위치
			startC = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			
			// 끝나는 위치
			endC = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				location[i][1] = Integer.parseInt(st.nextToken());
				location[i][0] = Integer.parseInt(st.nextToken());
			}
			
			permu2(0,0,startR, startC);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static void permu2(int cnt, int sum, int r, int c) {
		
		if(sum>answer) {
			return;
		}
		
		if(cnt==N) {
			sum += Math.abs(endR -r);
			sum += Math.abs(endC -c);
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				sum += Math.abs(location[i][0] - r);
				sum += Math.abs(location[i][1] - c);
				permu2(cnt+1, sum, location[i][0], location[i][1]);
				isVisited[i] = false;
				sum -= Math.abs(location[i][0] - r);
				sum -= Math.abs(location[i][1] - c);
			}
		}
	}

}
