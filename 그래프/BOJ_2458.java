package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ_2458_G4_키 순서
 * @Author mingggkeee
 * @Date 2022. 4. 6.
 * @Category : 플로이드 - 와샬
 */

public class BOJ_2458 {
	
	static int N, M, answer;
	static int[][] map;
	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		M = Integer.parseInt(st.nextToken());
		
		// 초기화는 무한대
		for(int i=0; i<=N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());	// 작은 거
			int num2 = Integer.parseInt(st.nextToken());	// 큰거
			map[num1][num2] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int[] knows = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] != INF) {
					knows[i]++;
					knows[j]++;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(knows[i] == N-1) {
				answer++;
			}
		}
		
		
		System.out.println(answer);
	}
	
}

