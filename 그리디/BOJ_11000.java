package 그리디;

import java.util.*;
import java.io.*;

/**
 * BOJ_11000_G5_강의실 배정
 * @author mingggkeee
 * 그리디 알고리즘
 */
public class BOJ_11000 {
	
	static int N;	// 수업의 개수
	static int [][] arr;	// 수업 시간 저장
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 : 수업시간이 시작되는 오름차순 우선 정렬, 동률시에 끝나는 시간으로 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o1[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(arr[0][1]);
		
		for(int i=1; i<N; i++) {
			if(queue.peek() <= arr[i][0]) {
				queue.poll();
			}
			
			queue.add(arr[i][1]);
		}
		
		System.out.println(queue.size());
		br.close();
	}
}
