package 그리디;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ_1202_G2_보석도둑
 * @author mingggkeee
 * 우선순위 큐, 그리디 알고리즘
 */

public class BOJ_1202 {
	
	static int N, K;
	static int[][] info;
	static boolean[] isVisited;
	static int[] bags;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 보석의 개수
		K = Integer.parseInt(st.nextToken());	// 가방의 개수
		
		info = new int[N][2];
		isVisited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());	// 보석의 무게
			info[i][1] = Integer.parseInt(st.nextToken());	// 보석의 가격
		}
		
		// 무게 오름차순 정렬하는데 무게가 같을 경우에는 가격을 내림차순으로 정렬
		Arrays.sort(info, new Comparator<int []> () {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[0]==o1[0]) {
					return o2[1]-o1[1];
				}
				return o1[0]-o2[0];
			}
			
		});
		
		bags = new int[K];
		
		for(int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		// 가방 오름차순
		Arrays.sort(bags);
		
		long result = 0;
		
		// 가격이 내림차순 정렬하기 위해
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0, j=0; i<K; i++) {
			
			while(j<N && info[j][0] <= bags[i]) {
				pq.offer(info[j++][1]);
			}
			
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
			
		}
		
		System.out.println(result);

		
	}

}
