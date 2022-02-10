package 그리디;

import java.io.*;
import java.util.*;

/**
 * BOJ_1931_S2_회의실 배정
 * @author mingggkeee
 * 그리디 알고리즘
 */

public class BOJ_1931 {
	
	static int N;
	static int[][] time;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 회의실 개수
		time = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 회의 끝나는 시간이 빠른순으로 정렬. 끝나는 시간이 같을경우 회의 시작 시간이 빠른순서로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		int answer = 0;
		int times = 0;
		for(int i=0; i<N; i++) {
			if(time[i][0] >= times) {
				times = time[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}

}
