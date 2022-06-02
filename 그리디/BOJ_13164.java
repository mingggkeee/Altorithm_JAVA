package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ_13164_G5_행복 유치원
 * @Author mingggkeee
 * @Date 2022. 6. 2.
 * @Category : 그리디
 */

public class BOJ_13164 {

	static int N, K;
	static int[] heights;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		heights = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		List<Integer> diff = new ArrayList<>();
		for(int i=1; i<N; i++) {
			diff.add(heights[i] - heights[i-1]);
		}
		
		Collections.sort(diff);
		
		for(int i=0; i<N-K; i++) {
			answer += diff.get(i);
		}
		
		System.out.println(answer);
	}
	
}
